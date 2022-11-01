package com.parkit.parkingsystem.integration.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.model.Ticket;

public class DataBasePrepareService {

    DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();

    public void clearDataBaseEntries(){
        Connection connection = null;
        try{
            connection = dataBaseTestConfig.getConnection();

            //set parking entries to available
            connection.prepareStatement("update parking set available = true").execute();

            //clear ticket entries;
            connection.prepareStatement("truncate table ticket").execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            dataBaseTestConfig.closeConnection(connection);
        }
    }
    
    public void simulateVehiculeEntry(TicketDAO ticketDao, Ticket ticket){
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = dataBaseTestConfig.getConnection();
            //set parking entries to available
            ps = connection.prepareStatement("update parking set available = false where parking_number=?");
            ps.setInt(1, ticket.getParkingSpot().getId());
            ps.execute();
            //clear ticket entries;
            ticketDao.saveTicket(ticket);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            dataBaseTestConfig.closePreparedStatement(ps);
            dataBaseTestConfig.closeConnection(connection);
        }
    }


}

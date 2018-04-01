/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import Uniplat.MySQLConnector;
import Uniplat.config;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yang
 */
public class AllUser {

    public String[][] getdata(String user, String date, String table) throws ParseException {

        String[] timedata;
        String[] userdata = null;
        String[] datetime;
        String[] yesterday;
        String yesday;
        String[] valuedata;
        String[] valuedata2 = null;
        String[][] backjson = null;
        String[] efficiency = null;
        boolean day=false;
        System.out.println(table);
        System.out.println(table.length());
        try {

            config c = new config();
            c.setDBname("Watchmen");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            String query = "SELECT * FROM Summary";
            userdata=sql.getdata(query,"Account");
            sql.close();
            

        } catch (Exception ex) {
            System.out.println("3");
            Logger.getLogger(GetHeartRateSum.class.getName()).log(Level.SEVERE, null, ex);
            backjson = new String[1][1];
            backjson[0][0] = ex.toString();
        }
       
        return backjson;
    }    
}

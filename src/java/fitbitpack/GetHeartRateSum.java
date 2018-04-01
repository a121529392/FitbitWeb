/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import static java.lang.System.console;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import myfitbit.Fitbit;
import myfitbit.Fitbit_Decorder;
import myfitbit.GetData;
import myfitbit.GetHR;


import myfitbit.MySQLConnector;
import myfitbit.config;

/**
 *
 * @author sian
 */
public class GetHeartRateSum {

    public String getdata(String user, String date, String period) throws SQLException {

        String periodtime = period;
        String userNameValue = user;
        String startdate = date;
        String backjson = "";
        
        try {
            config c = new config();
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            sql.doQuery("select access_token from access where account =  '" + user + "' ");
            StringBuffer rs = sql.getResultString();
            String str = rs.toString();
            System.out.println("S: " + str.length());

            str = str.substring(15, 288);
            System.out.println("S: " + str);
            sql.close();
            System.out.println(userNameValue);
            System.out.println(periodtime);
            GetHR hr = new GetHR(date, periodtime);
            backjson = hr.Sendget(str);
            System.out.println("backjson");
            System.out.println(backjson);
            Fitbit_Decorder.decode_heartrate(backjson, userNameValue);
        } catch (Exception ex) {
            Logger.getLogger(GetHeartRateSum.class.getName()).log(Level.SEVERE, null, ex);
            backjson = ex.toString();
        }

        return backjson;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myfitbit.Fitbit_Decorder;
import myfitbit.GetACT;
import myfitbit.MySQLConnector;
import myfitbit.config;

/**
 *
 * @author Yang
 */
public class GetActDetail {

    public String getdata(String user, String date, String period, String starttime, String endtime, String id) throws SQLException {

        String periodtime = period;
        String userNameValue = user;
        String startdate = date;
        String sttime = starttime;
        String edtime = endtime;
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
            GetACT hr = new GetACT(date, sttime, edtime, id, periodtime);
            backjson = hr.Sendget(str);
            System.out.println(id);
            System.out.println("backjson---");
            System.out.println(backjson);
            Fitbit_Decorder.decode_minute_ac(backjson, userNameValue, id);
        } catch (Exception ex) {
            Logger.getLogger(GetHeartRateSum.class.getName()).log(Level.SEVERE, null, ex);
            backjson = ex.toString();
        }

        return backjson;
    }

}

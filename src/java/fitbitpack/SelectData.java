/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import java.util.logging.Level;
import java.util.logging.Logger;
import Uniplat.MySQLConnector;
import myfitbit.config;

/**
 *
 * @author Yang
 */
public class SelectData {

    public String[][] getdata(String user, String date, String table) {

        String userNameValue = user;
        String startdate = date;
        String[][] backjson;
        String[] userdata;
        try {
            System.out.println("1");

            config c = new config();
            c.setDBname("uniplat");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            System.out.println("select * from " + table + " where User_ID =  '" + user + "' ");
            System.out.println("asdasd");
            backjson = sql.SelectAllData("select * from " + table + " where User_ID =  '" + user + "'");

            /*userdata = sql.getdata("SELECT * FROM " + table, "User_ID");
            for (int i = 0; i < userdata.length; i++) {
                if (userdata[i].equals(user.toString())) {
                    System.out.println(userdata[i]);
                }
                System.out.println(userdata[i].length() + " " + user.length());
            }*/
            System.out.println(backjson.length);
            for (int i = 0; i < backjson.length; i++) {
                for (int j = 0; j < backjson[i].length; j++) {
                    System.out.println(backjson[i][j]);
                }
            }
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

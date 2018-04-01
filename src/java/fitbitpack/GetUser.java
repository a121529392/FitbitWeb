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
import myfitbit.GetSLEEPDATA;
import myfitbit.MySQLConnector;
import myfitbit.config;

/**
 *
 * @author Yang
 */
public class GetUser {

    public String[] getdata() {


        String[] backjson;
        try {
            System.out.println("1");

            config c = new config();
            c.setDBname("uniplat");
            Uniplat.MySQLConnector sql = new Uniplat.MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            String query = "SELECT * FROM User";
            backjson = sql.getdata(query, "User_ID");
            System.out.println(backjson.length);
            for (int i = 0; i < backjson.length; i++) {
                for (int j = 0; j < backjson.length; j++) {
                    System.out.println(backjson[i]);
                }
            }
sql.close();
        } catch (Exception ex) {
            System.out.println("3");
            Logger.getLogger(GetHeartRateSum.class.getName()).log(Level.SEVERE, null, ex);
            backjson = new String[1];
            backjson[0] = ex.toString();
        }

        return backjson;
    }
}

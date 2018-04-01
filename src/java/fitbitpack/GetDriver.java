/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import Uniplat.MySQLConnector;
import Uniplat.config;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Chili
 */
public class GetDriver {
    public String[][] getdata(String table) throws ParseException, SQLException {
        String [][]backjson;
        String []user;
        String []state;
      config c = new config();
      c.setDBname("IoT");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();

            String query = "";
          query = "select * from IoT.driver_status as t1 where EXISTS (select driver_id,status,max(update_time) as B from IoT.driver_status" +
" group by driver_id having t1.driver_id = driver_id and t1.update_time =max(update_time));";
                //System.out.println(query);
                user = sql.getdata(query, "driver_id");
                state = sql.getdata(query, "status");
                backjson = new String[2][state.length];
                for(int j=0;j<2;j++){
                    for(int i=0;i<state.length;i++){
                        if(j==0){
                            backjson[j][i]=user[i];
                        }
                         if(j==1){
                            backjson[j][i]=state[i];
                        }
                    }
                }

                sql.close();
                return backjson;
    }
      public String[] getonedriver(String user) throws ParseException, SQLException {

        String []state;
         String []backjson;
      config c = new config();
      c.setDBname("IoT");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();

            String query = "";
          query = "select * from IoT.driver_status as t1 where driver_id='"+user+"' "
                  + " and EXISTS (select driver_id,status,max(update_time) as B from IoT.driver_status group by driver_id" +
" having t1.driver_id = driver_id and t1.update_time =max(update_time));";
                //System.out.println(query);
                state = sql.getdata(query, "status");
                backjson = new String[state.length];
                    for(int i=0;i<state.length;i++){
                            backjson[i]=state[i];
                    }
                sql.close();
                return backjson;
    } 
}

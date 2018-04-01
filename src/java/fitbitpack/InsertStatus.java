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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chili
 */
public class InsertStatus {
       public void senddata(String user,String status) throws ParseException, SQLException {

      config c = new config();
      c.setDBname("IoT");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = new Date();
String strDate = sdFormat.format(date);
            String query = "";
            String query2 = "insert into StatusTransform(User_ID,Reason,Status,UpdateTime) values('"+user+"', 'Forced off' ,'close','"+strDate+"');";
          query = "insert into IoT.driver_status(driver_id,status,plate_number,update_time) Values('"+user+"', '"+status+"','YZU888','"+strDate+"');";
          System.out.println(query);
          sql.updateQuery(query);
          sql.updateQuery(query2);

                sql.close();

    }   
}

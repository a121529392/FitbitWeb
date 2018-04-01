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
public class InsertMessage {
      public void senddata(String table,String user,String message) throws ParseException, SQLException {

      config c = new config();
      c.setDBname("Watchmen_APP");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();

            String query = "";
          query = "insert into Watchmen_APP.Massage(User_ID,Content) Values('"+user+"','"+message+"');";
          sql.updateQuery(query);

                sql.close();

    }
}

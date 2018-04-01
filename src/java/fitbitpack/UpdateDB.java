/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class UpdateDB {
    public void update(String user, String date,String table) throws SQLException {

        String userNameValue = user;
        String startdate = date;

        String backjson = "";
        Date today = new Date();       
        SimpleDateFormat nowdate = new java.text.SimpleDateFormat("YYYY-MM-dd"); 

        String now = nowdate.format(new java.util.Date());       
        System.out.println(now);
        try {
            config c = new config();
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            String query;
            System.out.println(table);
            query="delete from uniplat."+table+" where DateTime =  '" + now + "' and User_ID='"+user+"'";
            sql.updateQuery(query);
            System.out.println(query);
            
            if(table.equals("Heartrate_Detail")){
            query="insert INTO uniplat.Heartrate_Detail(User_ID  , DateTime , StartTime,EndTime , Value , Frequency,UpdateTime) SELECT User_Id  , '"+now+"' , StartTime,EndTime , Value , Frequency,UpdateTime FROM uniplat.Heartrate_Detail WHERE DateTime='" + date + "' and User_ID='"+user+"'";
            sql.updateQuery(query);
            System.out.println(query);
            System.out.println("success");
            }else if(table.equals("Sleep_Detail")){
            query="insert INTO uniplat.Sleep_Detail(User_ID , Log_ID , ID_Activity ,  DateTime , StartTime,EndTime , Value , Frequency,UpdateTime) SELECT User_Id  , Log_ID , ID_Activity ,  '"+now+"' , StartTime,EndTime , Value , Frequency,UpdateTime FROM uniplat."+table+" WHERE DateTime='" + date + "' and User_ID='"+user+"'";
            sql.updateQuery(query);
            System.out.println(query);
            System.out.println("success");    
            }else if(table.equals("Summary")){
            query="insert INTO uniplat.Summary(User_ID, DateTime, ID_Activity, Value, StartTime, Frequency,UpdateTime) SELECT User_Id  ,  '"+now+"' , ID_Activity , Value, StartTime , Frequency,UpdateTime FROM uniplat."+table+"  WHERE DateTime='" + date + "' and User_ID='"+user+"'";
            sql.updateQuery(query);
            System.out.println(query);
            System.out.println("success");    
            }
            if(table.equals("Activity_Detail")){
            query="insert INTO uniplat.Activity_Detail(User_ID ,ID_Activity , DateTime, Value , StartTime,EndTime  , Frequency,UpdateTime) SELECT User_Id  ,ID_Activity , '"+now+"', Value , StartTime,EndTime  , Frequency,UpdateTime FROM uniplat.Activity_Detail WHERE DateTime='" + date + "' and User_ID='"+user+"'";
            sql.updateQuery(query);
            System.out.println(query);
            System.out.println("success");
            }
            sql.close();
        } catch (Exception ex) {
            Logger.getLogger(GetHeartRateSum.class.getName()).log(Level.SEVERE, null, ex);
            backjson = ex.toString();
        }

    }
}

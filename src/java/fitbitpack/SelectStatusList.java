/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import Uniplat.MySQLConnector;
import Uniplat.config;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chili
 */
public class SelectStatusList {
       public String[][] getdata(String user, String date,String value) {

        String userNameValue = user;
        String startdate = date;
        int dayvalue = 0;
         System.out.println(value);
        String[][] backjson;
        String[] userdata;
        try {
           
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                java.util.Calendar cal2 = java.util.Calendar.getInstance();
                cal2.setTime(sdf.parse(date));
                System.out.println(value);
                String query;
                if(value.equals("1")){
                    dayvalue=1;
                cal.add(java.util.Calendar.DATE, dayvalue);
                
                }else if(value.equals("7")){
                    dayvalue=7;
                cal.add(java.util.Calendar.DATE, -1*dayvalue);    
                cal2.add(java.util.Calendar.DATE, 1);    
                }else if(value.equals("30")){
                    dayvalue=30;
                cal.add(java.util.Calendar.DATE, -1*dayvalue);
                cal2.add(java.util.Calendar.DATE, 1);
                }
                System.out.println(dayvalue);
                String end = sdf.format(cal.getTime());
                String newDate=sdf.format(cal2.getTime());
                System.out.println(end);
            myfitbit.config c = new myfitbit.config();
            c.setDBname("IoT");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            if(value.equals("1")){
                query="select * from StatusTransform where User_ID =  '" + user + "' and UpdateTime>'" + date + "' and  UpdateTime< '" + end + "' ";
            }else{
               query="select * from StatusTransform where User_ID =  '" + user + "' and UpdateTime<'" + newDate + "' and  UpdateTime> '" + end + "' ";
            }
            System.out.println(query);
            backjson = sql.SelectAllData(query);
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
        public String[][] getwork(String user, String date,String value) throws ParseException {
   String userNameValue = user;
        String startdate = date;
        int dayvalue = 0;
         System.out.println(value);
        String[][] backjson;
        String[] userdata;
        try {
           
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                java.util.Calendar cal2 = java.util.Calendar.getInstance();
                cal2.setTime(sdf.parse(date));
                System.out.println(value);
                String query;
                if(value.equals("1")){
                    dayvalue=1;
                cal.add(java.util.Calendar.DATE, dayvalue);
                
                }else if(value.equals("7")){
                    dayvalue=7;
                cal.add(java.util.Calendar.DATE, -1*dayvalue);    
                cal2.add(java.util.Calendar.DATE, 1);    
                }else if(value.equals("30")){
                    dayvalue=30;
                cal.add(java.util.Calendar.DATE, -1*dayvalue);
                cal2.add(java.util.Calendar.DATE, 1);
                }
                System.out.println(dayvalue);
                String end = sdf.format(cal.getTime());
                String newDate=sdf.format(cal2.getTime());
                System.out.println(end);
            myfitbit.config c = new myfitbit.config();
            c.setDBname("IoT");
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            if(value.equals("1")){
                query="select * from Watchmen_APP.PunchRecord where User_ID =  '" + user + "' and StartTime>'" + date + "' and  StartTime< '" + end + "'  ";
            }else{
               query="select * from Watchmen_APP.PunchRecord where User_ID =  '" + user + "' and StartTime<'" + newDate + "' and  StartTime> '" + end + "' ";
            }
            System.out.println(query);
            backjson = sql.SelectAllData(query);
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

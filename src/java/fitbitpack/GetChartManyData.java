/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitbitpack;

import Uniplat.MySQLConnector;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Uniplat.config;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Yang
 */
public class GetChartManyData {

    public String[][] getdata(String user, String date, String table, String value) throws ParseException, SQLException {
        int newvalue = 1;
        if (value.equals("7")) {
            newvalue = 7;
        }
        if (value.equals("30")) {
            newvalue = 30;
        }

        String[] timedata = null;
        String[] datetime = null;
        String[] valuedata = null;
        String[] timedata2 = null;
        String[] valuedata2 = null;
        String[] timedata3 = null;
        String[] valuedata3 = null;
        String[] yesterday;
        String yesday;
        System.out.println("MY"+table);
        String[][] backjson = null;
        try {

            config c = new config();
            if("PVT_History".equals(table)){
                System.out.println("success");
                c.setDBname("Watchmen_APP");
            }
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();
            //System.out.println(newvalue);
            String query;
            // String query = "SELECT * FROM Heartrate_Detail  Where DateTime = ' " + date + " ' ";
            if (table.equals("Heartrate_Detail")) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                cal.add(java.util.Calendar.DATE, (newvalue - 1) * -1);
               // System.out.println(sdf.format(cal.getTime()));
                String end = sdf.format(cal.getTime());
                query = "select * from " + table + " Where DateTime<='" + date + "'and DateTime>='" + end + "'and User_ID='" + user + "' order by DateTime asc,StartTime asc";
               // System.out.println(query);
                timedata = sql.getdata(query, "StartTime");
                datetime = sql.getdata(query, "DateTime");
                valuedata = sql.getdata(query, "Value");
                backjson = new String[3][valuedata.length];
                backjson[0][0] = date;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < valuedata.length; j++) {
                        if (i == 0) {
                            backjson[i][j] = datetime[j];
                            //    System.out.println(backjson[i][j]);
                        }
                        if (i == 1) {
                            backjson[i][j] = timedata[j];
                            //    System.out.println(backjson[i][j]);
                        }
                        if (i == 2) {
                            backjson[i][j] = valuedata[j];
                            //      System.out.println(backjson[i][j]);
                        }

                    }
                }
                
            }else if (table.equals("PVT_History")) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                cal.add(java.util.Calendar.DATE, (newvalue - 1) * -1);
               // System.out.println(sdf.format(cal.getTime()));
                String end = sdf.format(cal.getTime());
                
                query = "SELECT  *  FROM PVT_History WHERE( TestDate<='"+date+"' and TestDate>='"+end+"')AND User_ID='"+user+"'  order by TestDate,TestTime";
                System.out.println(query);
                datetime = sql.getdata(query, "TestDate");
                timedata = sql.getdata(query, "TestTime");
                for(int i=0;i<timedata.length;i++){
                    timedata[i]=datetime[i]+" "+timedata[i];
                }
                valuedata = sql.getdata(query, "MeanRT");
                String query2="SELECT *  FROM IoT.driver_status WHERE update_time<'"+date+"' and  update_time> '"+end+"' AND driver_id='"+user+"'";
                System.out.println(query2);
                timedata2 = sql.getdata(query2, "update_time");
                valuedata2 = sql.getdata(query2, "status");
                backjson = new String[4][valuedata.length];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < valuedata.length; j++) {
                        if (i == 0) {
                            backjson[i][j] = timedata[j];
                            //    System.out.println(backjson[i][j]);
                        }
                        if (i == 1) {
                            backjson[i][j] = valuedata[j];
                            //    System.out.println(backjson[i][j]);
                        }
                        if (i == 2) {
                            backjson[i][j] = timedata2[j];
                            //    System.out.println(backjson[i][j]);
                        }
                        if (i == 3) {
                            backjson[i][j] = valuedata2[j];
                            //    System.out.println(backjson[i][j]);
                        }
                    }
                }
            }else if (table.equals("Activity_Detail")) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                cal.add(java.util.Calendar.DATE, (newvalue - 1) * -1);
               // System.out.println(sdf.format(cal.getTime()));
                String end = sdf.format(cal.getTime());
                
                query = "SELECT SUM(value) as Value,ID_Activity,DateTime,User_ID,StartTime FROM uniplat.Activity_Detail WHERE( DateTime<='"+date+"' and DateTime>='"+end+"')AND User_ID='"+user+"' AND ID_Activity='steps' GROUP by hour( StartTime ),DateTime order by DateTime,StartTime";
                System.out.println(query);
                datetime = sql.getdata(query, "DateTime");
                timedata = sql.getdata(query, "StartTime");
                for(int i=0;i<timedata.length;i++){
                    timedata[i]=datetime[i]+" "+timedata[i];
                }
                valuedata = sql.getdata(query, "value");
                backjson = new String[2][valuedata.length];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < valuedata.length; j++) {
                        if (i == 0) {
                            backjson[i][j] = timedata[j];
                            //    System.out.println(backjson[i][j]);
                        }
                        if (i == 1) {
                            backjson[i][j] = valuedata[j];
                            //    System.out.println(backjson[i][j]);
                        }

                    }
                }
            } else if (table.equals("Sleep_Detail")) {
                String[] sum;
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateformat.parse(date));
                cal.add(java.util.Calendar.DATE, (newvalue - 1) * -1);
                String end = dateformat.format(cal.getTime());
                String[] efficiency;
                System.out.println(end);
                query = "select round(avg(Value),1) as Value from uniplat.Summary Where DateTime<='" + date + "'and DateTime>='" + end + "'and User_ID='" + user + "' and ID_Activity='efficiency' ";
                System.out.println(query);
                efficiency = sql.getdata(query, "Value");
                query = "select * from  uniplat.Summary Where DateTime>='" + end + "' and User_ID='" + user + "'and ID_Activity='minutesAsleep' order by StartTime asc";
                System.out.println(query);
                yesterday = sql.getdata(query, "StartTime");
                System.out.println(yesterday[0]);
                cal.setTime(datetimeformat.parse(yesterday[0]));
                System.out.println(yesterday[0]);
                String yestime = timeformat.format(cal.getTime());
                yesday = dateformat.format(cal.getTime());
                System.out.println(yestime);
                System.out.println(yesday);
                query = "select * from  uniplat.Summary Where DateTime='" + date + "' and User_ID='" + user + "'and ID_Activity='minutesAsleep' order by StartTime asc";
              //  System.out.println(query);
                String[] today;
                today = sql.getdata(query, "StartTime");
                sum = sql.getdata(query, "Value");
             //   System.out.println(today[0]);
                cal.setTime(datetimeformat.parse(today[0]));
                cal.add(Calendar.MINUTE, Integer.parseInt(sum[0]));
             //   System.out.println(today[0]);
                String todaytime = timeformat.format(cal.getTime());
                String tday = dateformat.format(cal.getTime());
               // System.out.println(todaytime);
                //System.out.println(tday);
                query = "select * from uniplat.Sleep_Detail Where (DateTime='" + yesday + "'and StartTime>='" + yestime + "')and   User_ID='" + user + "' order by DateTime,StartTime";
               // System.out.println(query);
                String manydate[] = sql.getdata(query, "DateTime");
                timedata = sql.getdata(query, "StartTime");
                valuedata = sql.getdata(query, "Value");
                for (int j = 0; j < valuedata.length; j++) {
                    timedata[j] = manydate[j] + " " + timedata[j];
                }
                query = "select * from uniplat.Sleep_Detail Where (DateTime>'" + yesday + "'and DateTime<'" + tday + "')and   User_ID='" + user + "' order by DateTime,StartTime";
               // System.out.println(query);
                manydate = sql.getdata(query, "DateTime");
                timedata2 = sql.getdata(query, "StartTime");
                valuedata2 = sql.getdata(query, "Value");
                for (int j = 0; j < valuedata2.length; j++) {
                    timedata2[j] = manydate[j] + " " + timedata2[j];
                }
                query = "select * from uniplat.Sleep_Detail Where (DateTime='" + tday + "'and StartTime<='" + todaytime + "')and   User_ID='" + user + "' order by DateTime,StartTime";
               // System.out.println(query);
                manydate = sql.getdata(query, "DateTime");
                timedata3 = sql.getdata(query, "StartTime");
                valuedata3 = sql.getdata(query, "Value");
                for (int j = 0; j < valuedata3.length; j++) {
                    timedata3[j] = manydate[j] + " " + timedata3[j];
                }
               
                backjson = new String[3][valuedata.length + valuedata2.length + valuedata3.length];
                backjson[2]=new String[1];
                backjson[2][0]=efficiency[0];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < valuedata.length; j++) {
                        if (i == 0) {
                            backjson[i][j] = timedata[j];
                        }
                        if (i == 1) {
                            backjson[i][j] = valuedata[j];
                        }
                    }

                }
                
                for (int i = 0; i < 2; i++) {
                    int jj = 0;
                    for (int j = valuedata.length; j < valuedata.length+valuedata2.length; j++) {

                        if (i == 0) {
                            backjson[i][j] = timedata2[jj];
                        }
                        if (i == 1) {
                            backjson[i][j] = valuedata2[jj];
                        }
                        jj++;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    int jj = 0;
                    for (int j = valuedata.length+valuedata2.length; j < valuedata.length+valuedata2.length+valuedata3.length; j++) {

                        if (i == 0) {
                            backjson[i][j] = timedata3[jj];
                        }
                        if (i == 1) {
                            backjson[i][j] = valuedata3[jj];
                        }
                        jj++;
                    }
                }
                
            }else if (table.equals("Summary")) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                cal.add(java.util.Calendar.DATE, (newvalue - 1) * -1);
             //   System.out.println(sdf.format(cal.getTime()));
                String end = sdf.format(cal.getTime());
                query = "select * from uniplat.Summary Where(DateTime<='" + date + "'and DateTime>='" + end + "') and User_ID='" + user + "' and (ID_Activity='restlessCount'OR ID_Activity='awakeCount'OR ID_Activity='minutesAsleep'OR ID_Activity='minutesAwake') order by DateTime";
                System.out.println(query);
                datetime = sql.getdata(query, "DateTime");
                valuedata = sql.getdata(query, "Value");
                timedata = sql.getdata(query, "ID_Activity");
                backjson = new String[3][valuedata.length];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < valuedata.length; j++) {
                        if (i == 0) {
                            backjson[i][j] = datetime[j];
                               // System.out.println(backjson[i][j]);
                        }
                        if (i == 1) {
                            backjson[i][j] = timedata[j];
                                //System.out.println(backjson[i][j]);
                        }
                        if (i == 2) {
                            backjson[i][j] = valuedata[j];
                                 // System.out.println(backjson[i][j]);
                        }

                    }
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < valuedata.length; j++) {
                        System.out.println(backjson[i][j]);
                    }
                }
                
            }   else {
                timedata = new String[1];
                valuedata = new String[1];
                datetime = new String[1];
                backjson = new String[3][valuedata.length];
            }

            System.out.println(backjson[0].length);
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

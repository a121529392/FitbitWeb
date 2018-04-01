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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Yang
 */
public class GetChart {

    public String[][] getdata(String user, String date, String table) throws ParseException {

        String[] timedata;
        String[] timedata2 = null;
        String[] datetime;
        String[] yesterday;
        String yesday;
        String[] valuedata;
        String[] valuedata2 = null;
        String[][] backjson = null;
        String[] efficiency = null;
        boolean day = false;
        System.out.println(table);
        System.out.println(table.length());
        try {

            config c = new config();
            if ("PVT_History".equals(table)) {
                System.out.println("success");
                c.setDBname("Watchmen_APP");
            }
            MySQLConnector sql = new MySQLConnector(c.getUrlstr(), c.getUserStr(), c.getPwStr(), c.getDBname());
            sql.connectDB();

            String query = "";

            if ("Sleep_Detail".equals(table)) {

                String[] sum;
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateformat.parse(date));

                query = "select * from  uniplat.Summary Where DateTime='" + date + "' and User_ID='" + user + "'and ID_Activity='minutesAsleep' order by StartTime asc";
                // System.out.println(query);
                yesterday = sql.getdata(query, "StartTime");
                //System.out.println(yesterday[0]);
                cal.setTime(datetimeformat.parse(yesterday[0]));
                // System.out.println(yesterday[0]);
                String yestime = timeformat.format(cal.getTime());
                yesday = dateformat.format(cal.getTime());
                // System.out.println(yestime);
                // System.out.println(yesday);
                query = "select * from uniplat.Summary Where DateTime='" + date + "' and User_ID='" + user + "' and ID_Activity='minutesAsleep'";
                // System.out.println(query);
                sum = sql.getdata(query, "Value");
                // System.out.println(sum[0]);
                cal.setTime(datetimeformat.parse(yesterday[0]));
                // System.out.println(yesterday[0]);
                cal.add(Calendar.MINUTE, Integer.parseInt(sum[0]));
                String newTime = timeformat.format(cal.getTime());
                // System.out.println(newTime);
                if (yesday.equals(date)) {
                    query = "select * from " + table + " Where DateTime='" + yesday + "' and User_ID='" + user + "'and StartTime>='" + yestime + "'and StartTime<='" + newTime + "'order by StartTime asc";
                    System.out.println(query);
                    timedata = sql.getdata(query, "StartTime");
                    valuedata = sql.getdata(query, "Value");
                    for (int j = 0; j < valuedata.length; j++) {
                        timedata[j] = yesday + " " + timedata[j];
                    }
                    backjson = new String[2][valuedata.length];
                } else {
                    query = "select * from " + table + " Where DateTime='" + yesday + "' and User_ID='" + user + "'and StartTime>='" + yestime + "'order by StartTime asc";
                    // System.out.println(query+"h1");
                    timedata = sql.getdata(query, "StartTime");
                    valuedata = sql.getdata(query, "Value");
                    for (int j = 0; j < valuedata.length; j++) {
                        timedata[j] = yesday + " " + timedata[j];
                    }
                    query = "select * from " + table + " Where DateTime='" + date + "' and User_ID='" + user + "'and StartTime<='" + newTime + "'order by StartTime asc";
                    // System.out.println(query+"h2");
                    timedata2 = sql.getdata(query, "StartTime");
                    valuedata2 = sql.getdata(query, "Value");
                    for (int j = 0; j < valuedata2.length; j++) {
                        timedata2[j] = date + " " + timedata2[j];
                    }
                    backjson = new String[2][valuedata.length + valuedata2.length];
                    day = true;
                }

            } else if ("Heartrate_Detail".equals(table)) {
                query = "select * from " + table + " Where DateTime='" + date + "' and User_ID='" + user + "'order by StartTime asc";
                //System.out.println(query);
                timedata = sql.getdata(query, "StartTime");
                valuedata = sql.getdata(query, "Value");
                backjson = new String[2][valuedata.length];

            } else if ("Activity_Detail".equals(table)) {
                query = "SELECT SUM(value) as Value FROM uniplat.Activity_Detail WHERE DateTime='" + date + "' AND User_ID='" + user + "' AND ID_Activity='steps'";
                System.out.println(query);
                efficiency = sql.getdata(query, "Value");
                query = "SELECT SUM(value) as Value,ID_Activity,DateTime,User_ID,StartTime FROM uniplat.Activity_Detail WHERE DateTime='" + date + "' AND User_ID='" + user + "' AND ID_Activity='steps' GROUP by hour( StartTime ) order by StartTime";
                System.out.println(query);
                datetime = sql.getdata(query, "DateTime");
                timedata = sql.getdata(query, "StartTime");
                for (int i = 0; i < timedata.length; i++) {
                    timedata[i] = datetime[i] + " " + timedata[i];
                }
                valuedata = sql.getdata(query, "value");
                backjson = new String[3][valuedata.length];
            } else if ("PVT_History".equals(table)) {
                query = "SELECT *  FROM Watchmen_APP.PVT_History WHERE TestDate='" + date + "' AND User_ID='" + user + "' order by TestTime asc";
                System.out.println(query);
                datetime = sql.getdata(query, "TestDate");
                timedata = sql.getdata(query, "TestTime");
                for (int i = 0; i < timedata.length; i++) {
                    timedata[i] = datetime[i] + " " + timedata[i];
                }
                valuedata = sql.getdata(query, "MeanRT");
                backjson = new String[4][valuedata.length];
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(sdf.parse(date));
                cal.add(java.util.Calendar.DATE, 1);
                String end = sdf.format(cal.getTime());
                String query2 = "SELECT *  FROM IoT.driver_status WHERE update_time>'" + date + "' and  update_time< '" + end + "' AND driver_id='" + user + "'";
                System.out.println(query2);
                timedata2 = sql.getdata(query2, "update_time");
                valuedata2 = sql.getdata(query2, "status");
                for (int i = 2; i < 4; i++) {
                    backjson[i] = new String[valuedata2.length];
                }
                for (int i = 2; i < 4; i++) {
                    for (int j = 0; j < valuedata2.length; j++) {
                        if (i == 2) {
                            backjson[i][j] = timedata2[j];
                        }
                        if (i == 3) {
                            backjson[i][j] = valuedata2[j];
                        }
                    }
                }

            } else if ("Summary".equals(table)) {

                query = "select round(avg(Value),1) as Value from uniplat.Summary Where DateTime='" + date + "' and User_ID='" + user + "' and ID_Activity='efficiency' ";
                efficiency = sql.getdata(query, "Value");
                query = "select * from uniplat.Summary Where DateTime='" + date + "' and User_ID='" + user + "' and (ID_Activity='restlessCount'OR ID_Activity='awakeCount'OR ID_Activity='minutesAsleep'OR ID_Activity='minutesAwake')";
                timedata = sql.getdata(query, "ID_Activity");
                valuedata = sql.getdata(query, "Value");
                backjson = new String[3][valuedata.length];
            } else {
                timedata = new String[1];
                valuedata = new String[1];
                timedata2 = new String[1];
                valuedata2 = new String[1];
                backjson = new String[3][valuedata.length];
            }

            System.out.println(date);

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
            if ("Sleep_Detail".equals(table) && day == true) {

                for (int i = 0; i < 2; i++) {
                    int jj = 0;
                    for (int j = valuedata.length; j < valuedata.length + valuedata2.length; j++) {
                        if (i == 0) {
                            backjson[i][j] = timedata2[jj];
                        }
                        if (i == 1) {
                            backjson[i][j] = valuedata2[jj];
                        }
                        jj++;
                    }
                }
            }
            if (backjson.length == 3) {
                backjson[2][0] = efficiency[0];
            }

         /*   for (int i = 0; i < 2; i++) {
                for (int j = 0; j < backjson[0].length; j++) {
                    System.out.println(backjson[i][j]);
                }
            }*/
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

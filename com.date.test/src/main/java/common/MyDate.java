package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    /** 
     * ʱ���ת�������ڸ�ʽ�ַ��� 
     * @param seconds ��ȷ������ַ��� 
     * @param formatStr 
     * @return 
     */  
    public static String timeStamp2Date(String seconds,String format) {  
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return "";  
        }  
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }   
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
    }  
    /** 
     * ���ڸ�ʽ�ַ���ת����ʱ��� 
     * @param date �ַ������� 
     * @param format �磺yyyy-MM-dd HH:mm:ss 
     * @return 
     */  
    public static String date2TimeStamp(String date_str,String format){  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            return String.valueOf(sdf.parse(date_str).getTime()/1000);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
      
    /** 
     * ȡ�õ�ǰʱ�������ȷ���룩 
     * @return 
     */  
    public static String timeStamp(){  
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);  
        return t;  
    }
    
    public static String currentDate(){
    	String timeStamp = timeStamp();  
    	long millTimeStamp = System.currentTimeMillis();
        
        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");  
        return "current date: " + date + "\ntimestamp is: " + timeStamp + "\nmilltimestamp is: " + millTimeStamp;
    }

    public static void main(String[] args) {
        if(args.length>0){
        	try{
        		if(args[0].equals("date2TimeStamp")){
                	System.out.println(date2TimeStamp(args[1],args[2]));
                }
        		else if(args[0].equals("timeStamp2Date")){
                	System.out.println(timeStamp2Date(args[1],args[2]));
                }
        		else{
                	System.out.println("help: \nsample1: java -jar com.date.test-0.0.1-SNAPSHOT.jar timeStamp2Date2 \"1543474552\" \"yyyy-MM-dd HH:mm:ss\"\nsample2: java -jar com.date.test-0.0.1-SNAPSHOT.jar date2TimeStamp \"2018-11-29 14:55:22\" \"yyyy-MM-dd HH:mm:ss\"");
                }
        	} catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
        else{
        	System.out.println("default");
            System.out.println(currentDate());
        }
    }  
}
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class isOpenNow {
	public static void main(String args[]){
        try{
            File file = new File("/Users/natsuko/UnitTest/sample.txt");

            if (checkBeforeReadfile(file)){
                BufferedReader br 
                    = new BufferedReader(new FileReader(file));

                String str, name, tmp, ampm;
				int close, ohour,omin,chour,cmin;
				String[] str1, temp, temp1;
                while((str = br.readLine()) != null){
                    System.out.println(str);
                    str1=str.split("\t");
                    name=str1[0];//店名
                    close=Integer.parseInt(str1[1]);//定休日
                    tmp=str1[2];
                    temp=tmp.split("[: ~]");
                    ohour=Integer.parseInt(temp[0]);//開店時間
                    omin=Integer.parseInt(temp[1]);//開店　分
                    temp1=temp[2].split("[M]");
                    chour=Integer.parseInt(temp1[1]);//閉店時間
                    System.out.println(chour);
                    ampm=temp1[0];
                    System.out.println(ampm);
                    cmin=Integer.parseInt(temp[3]);//閉店　分
                    getDate(close, ohour, omin, chour, cmin,ampm);
                }

                br.close();
            }else{
                System.out.println("ファイルが見つからないか開けません");
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    private static boolean checkBeforeReadfile(File file){
        if (file.exists()){
            if (file.isFile() && file.canRead()){
                return true;
            }
        }

        return false;
    }

	public static boolean IsOpenNow(int dayOfWeek, int hour, int close, int ohour, int chour, String ampm) {
	    if (dayOfWeek == close){
	    	System.out.println("Close now");
	    	return false;
	    }else if(ampm=="AM" && chour<hour){
	    	System.out.println("Open now");
	    	return true;
	    }
	    System.out.println("Open now");
	    return ohour <= hour && hour < chour;
	  }//int close, int ohour, int omin, int chour, int cmin
	//int dayOfWeek, int hour, int close, int ohour, int chour
	  
	  public static boolean getDate(int close, int ohour, int omin, int chour, int cmin, String ampm) {
	    Calendar calendar = Calendar.getInstance();
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    int hour = calendar.get(Calendar.HOUR_OF_DAY);
	    return IsOpenNow(dayOfWeek, hour,close, ohour, chour, ampm);
	  }
}




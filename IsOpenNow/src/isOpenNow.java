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
                    //temp1=temp[2].split("[M]");
                    //ampm=temp1[0];
                    chour=Integer.parseInt(temp[2]);//閉店時間　
                    cmin=Integer.parseInt(temp[3]);//閉店　分
                    System.out.println(temp[2]);
                    getDate(close, ohour, omin, chour, cmin);
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

	public static boolean isOpenNow(int dayOfWeek, int hour, int close, int ohour, int omin, int chour, int cmin) {
	    if (dayOfWeek == close){
	    	System.out.println("False");
	    	return false;
	    }
	    System.out.println("True");
	    return 9 <= ohour && chour < 17;
	  }
	  
	  public static boolean getDate(int close, int ohour, int omin, int chour, int cmin) {
	    Calendar calendar = Calendar.getInstance();
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    int hour = calendar.get(Calendar.HOUR_OF_DAY);
	    return isOpenNow(dayOfWeek, hour,close, ohour, omin,  chour, cmin);
	  }
}




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

                String str, name, tmp,close, ohour,omin,chour,cmin;
				String[] str1, temp;
                while((str = br.readLine()) != null){
                    System.out.println(str);
                    str1=str.split("\t");
                    name=str1[0];//店名
                    close=str1[1];//定休日
                    tmp=str1[2];
                    temp=tmp.split("[: ~]");
                    ohour=temp[0];//開店時間
                    omin=temp[1];//開店　分
                    chour=temp[2];//閉店時間　
                    cmin=temp[3];//閉店　分
                    //System.out.println(temp[1]);
                    
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

	public static boolean isOpenNow(int dayOfWeek, int hour) {
	    if (dayOfWeek == Calendar.SUNDAY ||
	        dayOfWeek == Calendar.SATURDAY)
	      return false;
	    return 9 <= hour && hour < 17;
	  }
	  
	  public static boolean isOpenNow() {
	    Calendar calendar = Calendar.getInstance();
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    int hour = calendar.get(Calendar.HOUR_OF_DAY);
	    return isOpenNow(dayOfWeek, hour);
	  }
}




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
				int data[]=new int[5];
				String[] str1, temp, temp1;
                while((str = br.readLine()) != null){
                    System.out.println(str);
                    str1=str.split("\t");
                    name=str1[0];//店名
                    data[0]=Integer.parseInt(str1[1]);//定休日
                    tmp=str1[2];
                    temp=tmp.split("[: ~]");
                    data[1]=Integer.parseInt(temp[0]);//開店時間
                    data[2]=Integer.parseInt(temp[1]);//開店　分
                    temp1=temp[2].split("[M]");
                    data[3]=Integer.parseInt(temp1[1]);//閉店時間
                    ampm=temp1[0];
                    System.out.println(ampm);
                    data[4]=Integer.parseInt(temp[3]);//閉店　分
                    getDate(data,ampm);
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

	public static boolean IsOpenNow(int dayOfWeek, int hour, int[] data, String ampm) {
	    if (dayOfWeek == data[0]){
	    	System.out.println("Close now");
	    	return false;
	    }else if(ampm=="AM" && hour<data[3]){
	    	System.out.println("Open now");
	    	return true;
	    }
	    System.out.println("Open now");
	    return data[1] <= hour && hour < data[3];
	  }
	  
	  public static boolean getDate(int[] data, String ampm) {
	    Calendar calendar = Calendar.getInstance();
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    int hour = calendar.get(Calendar.HOUR_OF_DAY);
	    return IsOpenNow(dayOfWeek, hour, data, ampm);
	  }
}




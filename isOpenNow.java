import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class isOpenNow {
	public static void fileOpen(String args[]){
        try{
            File file = new File("/Users/natsuko/UnitTest/sample.txt");

            if (checkBeforeReadfile(file)){
                BufferedReader br 
                    = new BufferedReader(new FileReader(file));

                String str, name, business;
				String[] str1, temp;
                while((str = br.readLine()) != null){
                    System.out.println(str);
                    str1=str.split("\t");
                    name=str1[0];
                    System.out.println("店名: "+ name);
                    business=str1[1];
                    System.out.println("営業時間" + business);
                    temp=business.split("[~ :]");
                    System.out.println(temp[1]);
                }

                br.close();
            }else{
                System.out.println("ファイルがないか開けません");
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




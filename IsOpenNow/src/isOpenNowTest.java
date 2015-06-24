import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;


public class isOpenNowTest {

        @Test
        //public void test() {                                                  
                public void testIsOpenNow() {
        			//int dayOfWeek(曜日), int hour(現在時刻), int close(定休日), int ohour(開業時間), int chour(終業時間), String ampm(日付をまたぐかどうか)
        			assertTrue(isOpenNow.IsOpenNow(Calendar.MONDAY, 8, 1, 7, 20, "PM"));
                    assertFalse(isOpenNow.IsOpenNow(Calendar.MONDAY, 9, 2, 8, 12, "PM"));//定休日と曜日が一緒
                    assertFalse(isOpenNow.IsOpenNow(Calendar.SUNDAY, 9, 1, 3, 18, "PM"));//定休日と曜日が一緒
                    assertTrue(isOpenNow.IsOpenNow(Calendar.MONDAY, 1, 1, 3, 2, "AM"));//日付をまたいで営業
                    assertTrue(isOpenNow.IsOpenNow(Calendar.FRIDAY, 3, 4, 20, 4, "AM"));//日付をまたいで営業
                    assertFalse(isOpenNow.IsOpenNow(Calendar.FRIDAY, 3, 7, 18, 2, "AM"));//日付をまたいで営業
                    

        }
        
                                                                        
}


import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;


public class isOpenNowTest {

        @Test
        //public void test() {                                                  
                public void testIsOpenNow() {
        			assertTrue(isOpenNow.IsOpenNow(Calendar.MONDAY, 8, 1, 7, 20, "PM"));
                    assertFalse(isOpenNow.IsOpenNow(Calendar.MONDAY, 9, 2, 8, 12, "AM"));//定休日と曜日が一緒
                    assertFalse(isOpenNow.IsOpenNow(Calendar.SUNDAY, 9, 1, 3, 18, "AM"));//定休日と曜日が一緒
                    assertTrue(isOpenNow.IsOpenNow(Calendar.MONDAY, 0, 1, 3, 2, "AM"));
                    
                    

        }
        
                                                                        
}


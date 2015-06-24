import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;


public class isOpenNowTest {

        @Test
        //public void test() {                                                  
                public void testIsOpenNow() {
        			//Method method = isOpenNow.class.getDeclaredMethod(isOpenNow, );
        			//method.setAccessible(true);
        			//int actual = int method.invoke(, args);
        			//assertFalse(isOpenNow.IsOpenNow());
        			//int dayOfWeek, int hour, int close, int ohour, int omin, int chour, int cmin
        			assertTrue(isOpenNow.IsOpenNow(Calendar.MONDAY, 8, 1, 7, 20));
                    assertFalse(isOpenNow.IsOpenNow(Calendar.MONDAY, 9, 2, 8, 12));
                    assertFalse(isOpenNow.IsOpenNow(Calendar.SUNDAY, 9, 1, 3, 18));
                    
                    

        }
        
                                                                        
}


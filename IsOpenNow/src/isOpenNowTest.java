import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class isOpenNowTest {

        @Test
        //public void test() {                                                  
                public void testIsOpenNow() {
                    assertFalse(isOpenNow.isOpenNow(Calendar.MONDAY, 8));
                    assertTrue(isOpenNow.isOpenNow(Calendar.MONDAY, 9));
                    assertFalse(isOpenNow.isOpenNow(Calendar.SUNDAY, 9));

        }
                                                                        
}


import static org.junit.Assert.*;

import org.junit.Test;


public class testMatrix {

	@Test
	public void test() {
		assertEquals(Matrix.main(3), 450.0, 1e-99);
		assertEquals(Matrix.main(4), 3680.0, 1e-99);
		assertEquals(Matrix.main(5), 18250.0, 1e-99);
	}

}

import static org.junit.Assert.*;

import org.junit.Test;


public class testMatrix {

	@Test
	public void test() {
		assertEquals(Matrix.main(3), 450.0, 1e-8);
		assertEquals(Matrix.main(4), 3680.0, 1e-8);
		assertEquals(Matrix.main(5), 18250.0, 1e-8);
		assertEquals(Matrix.main(300),54673987504423472.000000, 1e-8);
	}

}

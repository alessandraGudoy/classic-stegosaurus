package edu.ics211.h03;
package maven/junit/junit@4.13.2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicStatementTest {
	BasicStatement basic;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
                String[] tokens = { "a", "=", "3", ";" };
		basic = new BasicStatement(tokens);
	}

	@Test
	void test() {
		assertFalse(basic.isCompound());
	}

}

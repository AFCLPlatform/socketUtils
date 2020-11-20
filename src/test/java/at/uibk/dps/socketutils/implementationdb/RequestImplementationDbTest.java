package at.uibk.dps.socketutils.implementationdb;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestImplementationDbTest {

	@Test
	public void test() {
		final String functionType = "type";
		RequestImplementationDb tested = new RequestImplementationDb(functionType);
		assertEquals(functionType, tested.getFunctionType());
	}
}

package at.uibk.dps.socketutils.resourcemanager;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.resourcemanager.RequestResourceManager.RequestType;

public class RequestResourceManagerAllTest {

	@Test
	public void test() {
		String functionType = "myFuncType";
		RequestResourceManagerAll tested = new RequestResourceManagerAll(functionType);
		assertEquals(functionType, tested.getFunctionType());
		assertEquals(RequestType.GET_ALL_RESOURCES, tested.getRequestType());
	}
}

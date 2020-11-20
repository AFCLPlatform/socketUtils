package at.uibk.dps.socketutils.implementationdb;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.FunctionDetails;

public class UtilsSocketImplementationDpTest {

	@Test
	public void testRequest() {
		final String functionType = "type";
		RequestImplementationDb tested = UtilsSocketImplementationDb.generateRequest(functionType);
		assertEquals(functionType, tested.getFunctionType());
	}

	@Test
	public void testResponse() {
		FunctionDetails funcDet1 = mock(FunctionDetails.class);
		FunctionDetails funcDet2 = mock(FunctionDetails.class);

		List<FunctionDetails> funcDetList = new ArrayList<>(Arrays.asList(funcDet1, funcDet2));
		ResponseImplementationDb tested = UtilsSocketImplementationDb.generateResponse(funcDetList);
		assertEquals(funcDetList, tested.getImplementations());
	}
}

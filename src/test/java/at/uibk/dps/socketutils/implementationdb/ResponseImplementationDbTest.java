package at.uibk.dps.socketutils.implementationdb;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.FunctionDetails;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseImplementationDbTest {

	@Test
	public void test() {
		FunctionDetails funcDet1 = mock(FunctionDetails.class);
		FunctionDetails funcDet2 = mock(FunctionDetails.class);

		List<FunctionDetails> funcDetList = new ArrayList<>(Arrays.asList(funcDet1, funcDet2));
		ResponseImplementationDb tested = new ResponseImplementationDb(funcDetList);
		assertEquals(funcDetList, tested.getImplementations());
	}
}

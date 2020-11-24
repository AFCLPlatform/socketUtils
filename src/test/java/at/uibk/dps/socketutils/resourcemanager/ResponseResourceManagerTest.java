package at.uibk.dps.socketutils.resourcemanager;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.FunctionDetails;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseResourceManagerTest {

	@Test
	public void test() {
		FunctionDetails funcDetMock1 = mock(FunctionDetails.class);
		FunctionDetails funcDetMock2 = mock(FunctionDetails.class);
		List<FunctionDetails> funcDetList = new ArrayList<>(Arrays.asList(funcDetMock1, funcDetMock2));
		ResponseResourceManager tested = new ResponseResourceManager(funcDetList);
		assertEquals(funcDetList, tested.getFilteredImplementations());
	}
}

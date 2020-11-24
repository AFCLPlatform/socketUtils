package at.uibk.dps.socketutils.mapping_annotator;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import at.uibk.dps.socketutils.mapping_annotator.RequestMappingAnnotator.RequestType;

public class RequestMappingAnnotatorInitTest {

	@Test
	public void test() {

		var typeMock1 = mock(RequestType.class);
		var typeMock2 = mock(RequestType.class);
		var typeList = new ArrayList<>(Arrays.asList(typeMock1, typeMock2));

		var structMock1 = mock(MappingStruct.class);
		var structMock2 = mock(MappingStruct.class);
		var structList = new ArrayList<>(Arrays.asList(structMock1, structMock2));

		var attrMap = new HashMap<String, String>();
		String attrName1 = "attr1";
		String attrName2 = "attr2";
		String config1 = "config1";
		String config2 = "config2";
		attrMap.put(attrName1, config1);
		attrMap.put(attrName2, config2);

		RequestMappingAnnotatorInit tested = new RequestMappingAnnotatorInit(typeList, structList, attrMap);
		assertEquals(typeList, tested.getRequestTypes());
		assertEquals(structList, tested.getMappings());
		assertEquals(RequestType.INIT_REQUEST, tested.getRequestType());
		assertEquals(attrMap, tested.getConfigurationAttributes());
	}
}

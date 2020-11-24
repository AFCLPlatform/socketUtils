package at.uibk.dps.socketutils.mapping_annotator;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.mapping_annotator.RequestMappingAnnotator.RequestType;

import static org.mockito.Mockito.mock;

public class RequestMappingAnnotatorTest {

	@Test
	public void test() {
		RequestType mockType = mock(RequestType.class);
		RequestMappingAnnotator annotatorRequest = new RequestMappingAnnotator(mockType);
		assertEquals(mockType, annotatorRequest.getRequestType());
	}
}

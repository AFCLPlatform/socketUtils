package at.uibk.dps.socketutils.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionDetailsTest {

	@Test
	public void test() {
		final String lang = "java";
		final String link = "myLink";
		final boolean isFree = true;
		
		FunctionDetails tested = new FunctionDetails(lang, link, isFree);
		assertEquals(lang, tested.getLanguage());
		assertEquals(link, tested.getFunctionLink());
		assertTrue(tested.isFreeInvocations());
	}
}

package at.uibk.dps.socketutils.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigurationAttributeTest {

	@Test
	public void test() {
		final String key = "key";
		final String value = "value";
		ConfigurationAttribute tested = new ConfigurationAttribute(key, value);
		assertEquals(key, tested.getKey());
		assertEquals(value, tested.getValue());
	}
}

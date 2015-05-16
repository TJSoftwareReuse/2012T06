package com.rs;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.Team06.PM;

import tj.reuse.ConfigComponent;

public class ServerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWriteTestData() {
		ConfigComponent cfg = new ConfigComponent();
		Properties prop = cfg.readProperties("settings.txt");
		int teamCount = Integer.parseInt(prop.getProperty("TeamCount","0"));
		int memberCount = Integer.parseInt(prop.getProperty("MemberCount","0"));
		
		assertEquals(10, teamCount);
		assertEquals(46, memberCount);
	}

	@Ignore
	@Test
	public void testMain() {
	}

}

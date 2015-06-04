import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

import tj.reuse.ConfigComponent;


public class ServerTest {

	@Test
	public void testWriteTestData() {
		ConfigComponent cfg = new ConfigComponent();
		
		Properties prop = cfg.readProperties("settings.txt");
				
		int teamCount = Integer.parseInt(prop.getProperty("TeamCount","0"));
				int memberCount = Integer.parseInt(prop.getProperty("MemberCount","0"));
				String GroupName = prop.getProperty("TeamName_"+1);
				
		String MemberTeamNumber=prop.getProperty("Member_Team_"+1);
				
		String MemberName= prop.getProperty("MemberName_"+1);
				
		assertEquals(10, teamCount);
				
		assertEquals(46, memberCount);
				
		assertEquals("Group1", GroupName);
				
		assertEquals("1", MemberTeamNumber);
				
		assertEquals("Œ‚“›∑∆", MemberName);

	}

	@Test
	public void testLoadTeamData() {
		fail("Not yet implemented");
	}

	@Test
	public void testReloadConfiguration() {
		fail("Not yet implemented");
	}

	@Test
	public void testResetLicense() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPMSettings() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFMSettings() {
		fail("Not yet implemented");
	}

	@Test
	public void testResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}

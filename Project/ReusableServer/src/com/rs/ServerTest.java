package com.rs;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
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
		String GroupName = prop.getProperty("TeamName_"+1);
		String MemberTeamNumber=prop.getProperty("Member_Team_"+1);
		String MemberName= prop.getProperty("MemberName_"+1);
		
		assertEquals(10, teamCount);
		assertEquals(46, memberCount);
		assertEquals("Group1", GroupName);
		assertEquals("1", MemberTeamNumber);
		assertEquals("���ݷ�", MemberName);
	}


	@Test
	public void testTeam() {
		Server ser=new Server();
		Map<String,String> team=Server.Team();
		String stuTeam = team.get("��Զ");
		assertEquals("Group10",stuTeam);
		}
	
	@Test
	public void testResult(){
		Server ser=new Server();
		
		assertEquals("Your team name is Group10",ser.Result(ser.Team(),"��Զ"));
		assertEquals("Member ABC not found",ser.Result(ser.Team(),"ABC"));
		assertEquals("Your team name is Group6",ser.Result(ser.Team(),"����"));
		assertEquals("Your team name is Group6",ser.Result(ser.Team(),"����"));
		assertEquals("Your team name is Group6",ser.Result(ser.Team(),"��˧"));
		assertEquals("Your team name is Group6",ser.Result(ser.Team(),"ʱ��"));
		assertEquals("Your team name is Group6",ser.Result(ser.Team(),"Τ�ᾳ"));
		assertEquals("Your team name is Group5",ser.Result(ser.Team(),"���峿"));
		assertEquals("Your team name is Group5",ser.Result(ser.Team(),"���"));
		assertEquals("Your team name is Group5",ser.Result(ser.Team(),"�����"));
		assertEquals("Denied",ser.Result(ser.Team(),"�����"));
	}

}

package com.rs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

import tj.reuse.ConfigComponent;

import com.Team06.LisenceClass;
import com.Team06.PM;

import edu.tongji.FaultManagement;

public class Server {

	public final static int SERVICE_PORT = 3999;
	public final static String CONFIG_FILE_NAME = "settings.txt";
	
	public static void writeTestData()
	{
		ConfigComponent cfg = new ConfigComponent();
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamCount", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberCount", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_1", "Group1");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_2", "Group2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_1", "Po Po");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_1", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_2", "Tinky Winky");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_2", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_3", "Laa Laa");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_3", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_4", "Dipsy");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_4", "1");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		writeTestData();
		
		// load config file
		ConfigComponent cfg = new ConfigComponent();
		Properties prop = cfg.readProperties(CONFIG_FILE_NAME);
		
		// read from database
		int teamCount = Integer.parseInt(prop.getProperty("TeamCount","0"));
		int memberCount = Integer.parseInt(prop.getProperty("MemberCount","0"));
		String teamNames[] = new String[teamCount];
		String memberNames[] = new String[memberCount];
		Map<String,String> memberTeam = new HashMap<String,String>();
		for (int i=1;i<=teamCount;i++) teamNames[i-1]=prop.getProperty("TeamName_"+i);
		for (int i=1;i<=memberCount;i++)
		{
			memberNames[i-1]=prop.getProperty("MemberName_"+i);
			int teamID = Integer.parseInt(prop.getProperty("Member_Team_"+i));
			if (teamID>=1 && teamID<=teamCount)
			{
				memberTeam.put(memberNames[i-1], teamNames[teamID-1]);
			}
		}
		
		// load fault manager
		FaultManagement fm = FaultManagement.getInstance();
		
		// load perf manager
		PM pm = new PM();
		
		// load license manager
		LisenceClass lic = new LisenceClass();
		
		// start service
		ServerSocket srvSock = new ServerSocket(SERVICE_PORT);
		fm.generateWarningMessage("Server is listening on port "+srvSock.getLocalPort());
		while (true)
		{
			Socket clntSock = srvSock.accept();
			SocketAddress clntAddress = clntSock.getRemoteSocketAddress();
			fm.generateWarningMessage("Accepts connection from "+clntAddress.toString());
			
			// create i/o streams
			InputStream rawRx = clntSock.getInputStream();
			OutputStream rawTx = clntSock.getOutputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(rawRx));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(rawTx));

			writer.println("Welcome to team6");
			writer.flush();
			
			// receive student name
			String stuName = reader.readLine().replace("\n", "");
			PM.sendMsg("ReceivedMessages",1);
			
			// check if license is valid
			if (lic.useLisence())
			{
				// process request
				fm.generateWarningMessage("In Service");
				PM.sendMsg("AcceptedRequests",1);
				
				// query
				if (memberTeam.containsKey(stuName))
				{
					String stuTeam = memberTeam.get(stuName); 
					writer.println("Your team name is "+stuTeam);
				}else
				{
					writer.println("Member "+stuName+" not found");
				}
				
				PM.sendMsg("ResponseMessages",1);
			}else
			{
				// reject
				fm.generateWarningMessage("Reject due to license expiration");
				PM.sendMsg("RejectedRequests",1);
				
				PM.sendMsg("ResponseMessages",1);
				writer.println("Denied");
			}

			writer.flush();
			clntSock.close();
			fm.generateWarningMessage("Connection closed");
		}
	}

}

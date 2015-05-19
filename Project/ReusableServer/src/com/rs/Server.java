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
	// load fault manager
	static FaultManagement fm = FaultManagement.getInstance();
	
	// load perf manager
	PM pm = new PM();
	
	// load license manager
	static LisenceClass lic = new LisenceClass();
	
	public static void writeTestData()
	{
		ConfigComponent cfg = new ConfigComponent();
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamCount", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberCount", "46");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_1", "Group1");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_2", "Group2");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_3", "Group3");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_4", "Group4");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_5", "Group5");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_6", "Group6");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_7", "Group7");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_8", "Group8");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_9", "Group9");
		cfg.writeProperties(CONFIG_FILE_NAME, "TeamName_10", "Group10");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_1", "���ݷ�");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_1", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_2", "���컶");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_2", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_3", "����˹");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_3", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_4", "�����B");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_4", "1");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_5", "��Цӯ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_5", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_6", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_6", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_7", "��");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_7", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_8", "��ΰ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_8", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_9", "�س�");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_9", "2");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_10", "��ʥ��");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_10", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_11", "�˱���");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_11", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_12", "���ȸ�");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_12", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_13", "֣�¿�");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_13", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_14", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_14", "3");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_15", "������");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_15", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_16", "���ﳽ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_16", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_17", "���ĳ�");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_17", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_18", "��ˬ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_18", "4");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_19", "���峿");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_19", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_20", "���");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_20", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_21", "�����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_21", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_22", "�����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_22", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_23", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_23", "5");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_24", "��˧");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_24", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_25", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_25", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_26", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_26", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_27", "Τ�ᾳ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_27", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_28", "ʱ��");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_28", "6");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_29", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_29", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_30", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_30", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_31", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_31", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_32", "���");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_32", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_33", "�ں�");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_33", "7");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_34", "������");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_34", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_35", "������");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_35", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_36", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_36", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_37", "���");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_37", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_38", "��־��");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_38", "8");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_39", "���");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_39", "9");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_40", "����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_40", "9");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_41", "����Դ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_41", "9");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_42", "����Ծ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_42", "9");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_43", "��ľ��");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_43", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_44", "��Զ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_44", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_45", "�����");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_45", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_46", "Ҷ��Ȩ");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_46", "10");
	}
	
	public static Map<String, String> Team(){
		ConfigComponent cfg = new ConfigComponent();
		Properties prop = cfg.readProperties(CONFIG_FILE_NAME);
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
		return memberTeam;
	}
	
	public static String Result(Map<String, String> Team,String Stu){
		PM.sendMsg("ReceivedMessages",1);
		if (lic.useLisence())
			{
				// process request
				fm.generateWarningMessage("In Service");
				PM.sendMsg("AcceptedRequests",1);
				
				// query
				if (Team.containsKey(Stu))
				{
					String stuTeam = Team.get(Stu);
					PM.sendMsg("ResponseMessages",1);
					return "Your team name is "+stuTeam;
				}else
				{
					PM.sendMsg("ResponseMessages",1);
					return "Member "+Stu+" not found";
				}				
				
			}
		else{
				// reject
				fm.generateWarningMessage("Reject due to license expiration");
				PM.sendMsg("RejectedRequests",1);
				
				PM.sendMsg("ResponseMessages",1);
				return "Denied";
			}
		
	}
	
	public static void main(String[] args) throws IOException {
		writeTestData();
		Map<String,String> memberTeam = new HashMap<String,String>();
		memberTeam=Team();
		
		// load config file
//		ConfigComponent cfg = new ConfigComponent();
//		Properties prop = cfg.readProperties(CONFIG_FILE_NAME);
		
		// read from database
//		int teamCount = Integer.parseInt(prop.getProperty("TeamCount","0"));
//		int memberCount = Integer.parseInt(prop.getProperty("MemberCount","0"));
//		String teamNames[] = new String[teamCount];
//		String memberNames[] = new String[memberCount];
//		Map<String,String> memberTeam = new HashMap<String,String>();
//		for (int i=1;i<=teamCount;i++) teamNames[i-1]=prop.getProperty("TeamName_"+i);
//		for (int i=1;i<=memberCount;i++)
//		{
//			memberNames[i-1]=prop.getProperty("MemberName_"+i);
//			int teamID = Integer.parseInt(prop.getProperty("Member_Team_"+i));
//			if (teamID>=1 && teamID<=teamCount)
//			{
//				memberTeam.put(memberNames[i-1], teamNames[teamID-1]);
//			}
//		}
		
//		// load fault manager
//		FaultManagement fm = FaultManagement.getInstance();
//		
//		// load perf manager
//		PM pm = new PM();
//		
//		// load license manager
//		LisenceClass lic = new LisenceClass();
		
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
			writer.println(Result(memberTeam,stuName));
			
//			PM.sendMsg("ReceivedMessages",1);
			
			// check if license is valid
//			if (lic.useLisence())
//			{
//				// process request
//				fm.generateWarningMessage("In Service");
//				PM.sendMsg("AcceptedRequests",1);
//				
//				// query
//				if (memberTeam.containsKey(stuName))
//				{
//					String stuTeam = memberTeam.get(stuName); 
//					writer.println("Your team name is "+stuTeam);
//				}else
//				{
//					writer.println("Member "+stuName+" not found");
//				}
//				
//				PM.sendMsg("ResponseMessages",1);
//			}else 			{
//				// reject
//				fm.generateWarningMessage("Reject due to license expiration");
//				PM.sendMsg("RejectedRequests",1);
//				
//				PM.sendMsg("ResponseMessages",1);
//				writer.println("Denied");
//			}

			writer.flush();
			clntSock.close();
			fm.generateWarningMessage("Connection closed");
		}
	}

}

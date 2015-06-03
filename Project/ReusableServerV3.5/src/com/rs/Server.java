package com.rs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
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
	
	static Map<String, String> teamData;
	
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
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_1", "吴逸菲");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_1", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_2", "黄徐欢");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_2", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_3", "李亚斯");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_3", "1");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_4", "许铭淏");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_4", "1");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_5", "王笑盈");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_5", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_6", "孙琳");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_6", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_7", "许舰");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_7", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_8", "李伟");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_8", "2");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_9", "关晨");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_9", "2");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_10", "胡圣托");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_10", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_11", "邓冰茜");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_11", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_12", "张奕格");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_12", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_13", "郑勇俊");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_13", "3");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_14", "代蒙");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_14", "3");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_15", "梁竞文");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_15", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_16", "彭秋辰");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_16", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_17", "胡文超");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_17", "4");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_18", "杨爽");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_18", "4");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_19", "关清晨");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_19", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_20", "杨春雨");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_20", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_21", "周泽宏");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_21", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_22", "杨宇歆");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_22", "5");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_23", "张良");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_23", "5");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_24", "喻帅");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_24", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_25", "刘蕊");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_25", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_26", "张旭晨");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_26", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_27", "韦吾境");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_27", "6");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_28", "时雨");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_28", "6");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_29", "尹巧");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_29", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_30", "方程");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_30", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_31", "赵鹏");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_31", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_32", "黄昕");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_32", "7");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_33", "于航");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_33", "7");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_34", "丁宇笙");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_34", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_35", "邱尚昭");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_35", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_36", "高屹");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_36", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_37", "杨丰");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_37", "8");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_38", "贺志鹏");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_38", "8");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_39", "陈璐");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_39", "9");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_40", "褚振方");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_40", "9");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_41", "陈启源");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_41", "9");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_42", "于自跃");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_42", "9");
		
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_43", "姜木慧");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_43", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_44", "王远");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_44", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_45", "刘禹嘉");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_45", "10");
		cfg.writeProperties(CONFIG_FILE_NAME, "MemberName_46", "叶剑权");
		cfg.writeProperties(CONFIG_FILE_NAME, "Member_Team_46", "10");
	}
	
	public static boolean loadTeamData(ConfigComponent cfg, String filename){
		Properties prop = cfg.readProperties(filename);
		int teamCount = Integer.parseInt(prop.getProperty("TeamCount","0"));
		int memberCount = Integer.parseInt(prop.getProperty("MemberCount","0"));
		String teamNames[] = new String[teamCount];
		String memberNames[] = new String[memberCount];
		Map<String,String> memberTeam = new HashMap<String,String>();
		for (int i=1;i<=teamCount;i++)
		{
			teamNames[i-1]=prop.getProperty("TeamName_"+i);
			memberTeam.put(teamNames[i-1], "");
		}
		for (int i=1;i<=memberCount;i++)
		{
			memberNames[i-1]=prop.getProperty("MemberName_"+i);
			int teamID = Integer.parseInt(prop.getProperty("Member_Team_"+i));
			if (teamID>=1 && teamID<=teamCount)
			{
				memberTeam.put(teamNames[teamID-1], memberTeam.get(teamNames[teamID-1])+memberNames[i-1]+";");
			}
		}
		teamData = memberTeam;
		return true;
	}
	
	public static void reloadConfiguration(String filename)
	{
		ConfigComponent cfg = new ConfigComponent();
		loadTeamData(cfg, filename);
	}
	
	public void resetLicense(int newNum)
	{
		lic.resetLisenceNum(newNum);
	}
	
	public void setPMSettings(long newInterval, String newPath)
	{
		PM.setPrintInterval(newInterval);
		if (newPath != null) PM.setLogFilePath(newPath);
	}
	
	public void setFMSettings(String newPath)
	{
		fm.setLogDirPath(newPath);
	}
	
	public static String Result(Map<String, String> Team,String Grp){
		PM.sendMsg2("ReceivedMessages",1);
		if (lic.useLisence())
			{
				// process request
				fm.generateWarningMessage("In Service");
				PM.sendMsg2("AcceptedRequests",1);
				
				// query
				if (Team.containsKey(Grp))
				{
					String stuTeam = Team.get(Grp);
					PM.sendMsg2("ResponseMessages",1);
					return "Members: "+stuTeam+"\n";
				}else
				{
					PM.sendMsg2("ResponseMessages",1);
					return "Group "+Grp+" not found\n";
				}				
				
			}
		else{
				// reject
				fm.generateWarningMessage("Reject due to license expiration");
				PM.sendMsg2("RejectedRequests",1);
				
				PM.sendMsg2("ResponseMessages",1);
				return "Denied\n";
			}
		
	}
	
	public static void main(String[] args) throws IOException {
		writeTestData();
		
		// load config file
		reloadConfiguration(CONFIG_FILE_NAME);
		
		// start service
		try (ServerSocket srvSock = new ServerSocket(SERVICE_PORT)) {
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
				DataOutputStream dwriter = new DataOutputStream(rawTx);

				writer.println("Welcome to team6");
				writer.flush();
				
				// receive group name
				try
				{
					while (true)
					{
					String grpName = reader.readLine().replace("\n", "");
					dwriter.write(Result(teamData,grpName).getBytes("utf-8"));
					dwriter.flush();
					}
				}
				catch (Exception ex)
				{
				}

				clntSock.close();
				fm.generateWarningMessage("Connection closed");
			}
		}
		
	}

}
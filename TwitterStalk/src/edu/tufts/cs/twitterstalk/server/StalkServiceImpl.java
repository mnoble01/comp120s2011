package edu.tufts.cs.twitterstalk.server;

import java.util.ArrayList;

import edu.tufts.cs.twitterstalk.client.StalkService;
import edu.tufts.cs.twitterstalk.client.TwitterInfo;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StalkServiceImpl extends RemoteServiceServlet implements StalkService {

	public String greetServer(String input)
	{
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	public ArrayList<TwitterInfo> stalk(String username)
	{
		ArrayList <TwitterInfo> list = new ArrayList<TwitterInfo>();
		list.add(new TwitterInfo("tufts_cs_mchow"));
		list.add(new TwitterInfo("ctraganos"));
		list.add(new TwitterInfo("rmondello"));
		list.add(new TwitterInfo("Montejam"));
		list.add(new TwitterInfo("joelbgreenberg"));
		return list;
	}
}

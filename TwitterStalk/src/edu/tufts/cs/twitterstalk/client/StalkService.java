package edu.tufts.cs.twitterstalk.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

@RemoteServiceRelativePath("stalk")
public interface StalkService extends RemoteService
{
	String greetServer(String name);
	ArrayList <TwitterInfo> stalk (String username);
}

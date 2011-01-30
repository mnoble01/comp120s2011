package edu.tufts.cs.twitterstalk.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StalkServiceAsync
{
	void greetServer(String input, AsyncCallback<String> callback);
	void stalk(String username, AsyncCallback<ArrayList<TwitterInfo>> callback);
}

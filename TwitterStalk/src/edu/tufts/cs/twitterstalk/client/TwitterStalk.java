package edu.tufts.cs.twitterstalk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TwitterStalk implements EntryPoint
{
	private final StalkServiceAsync ss = GWT.create(StalkService.class);
	private HorizontalPanel hp;
	private Label lbl;
	private TextBox username;
	private Button submit;
	private HTML output;
	
	public void onModuleLoad()
	{
		hp = new HorizontalPanel();
		lbl = new Label("Twitter Username: ");
		hp.add(lbl);
		username = new TextBox();
		hp.add(username);
		submit = new Button("Stalk");
		submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event)
			{
				submit();
			}
		});
		hp.add(submit);
		RootPanel.get("search").add(hp);
	}
	
	private void submit()
	{
		output = new HTML();
		String tname = username.getText().trim();
		ss.stalk(tname, new AsyncCallback<ArrayList<TwitterInfo>>() {
			public void onFailure(Throwable caught)
			{
			}
			
			public void onSuccess(ArrayList<TwitterInfo> twitterSerArray)
			{
				String outputStr;
				if (twitterSerArray.isEmpty()) {
					outputStr = "<h2>No results</h2>";
				}
				else {
					Iterator <TwitterInfo> it = twitterSerArray.iterator();
					outputStr = "<ul>";
					while (it.hasNext()) {
						TwitterInfo info = it.next();
						outputStr += "<li>" + info.getUsername() + "</li>";
					}
					outputStr += "</ul>";
				}
				output = new HTML();
				output.setHTML(outputStr);
				RootPanel.get("results").add(output);
			}		
		});
		RootPanel.get("results").add(output);
	}
}

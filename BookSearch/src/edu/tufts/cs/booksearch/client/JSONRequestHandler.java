package edu.tufts.cs.booksearch.client;

import com.google.gwt.core.client.JavaScriptObject;

public interface JSONRequestHandler 
{
	public void onRequestComplete (JavaScriptObject json);
}

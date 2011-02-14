/*
 * Book search using Google Books API
 * Written by Ming Chow
 * Last updated on February 6, 2011
 */

package edu.tufts.cs.booksearch.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.*;

public class BookSearch implements EntryPoint
{
	private static final String GOOGLE_BOOKS_API_PART1 = "http://books.google.com/books?bibkeys=ISBN:";
	private static final String GOOGLE_BOOKS_API_PART2 = "&jscmd=viewapi&callback=";

	private HorizontalPanel hp;
	private Label label;
	private TextBox searchBox;
	private Button submit;
	private HTML result;
	private String isbn; // The book ISBN that was entered

	public void onModuleLoad()
	{
		// Create simple search interface: a label, search box, and submit button
		result = new HTML();
		hp = new HorizontalPanel();
		label = new Label("ISBN:");
		hp.add(label);
		searchBox = new TextBox();
		searchBox.setMaxLength(13);
		searchBox.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress (KeyPressEvent event)
			{
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					findBook();
				}
			}
		});
		hp.add(searchBox);
		submit = new Button("Search Book");
		submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				findBook();
			}
		});
		hp.add(submit);
		
		// Add the horizontal panel with my widgets to HTML page inside "search" DIV
		RootPanel.get("search").add(hp);
	}

	private void findBook()
	{
		// Check to make sure that ISBN is either 10 or 13 digits long
		String temp = searchBox.getText().trim();
		String url;
		if (temp.matches("([0-9X]{10}|[0-9X]{13})$")) {
			isbn = temp;
			
			// Construct the call to the Google Books API
			url = GOOGLE_BOOKS_API_PART1 + isbn + GOOGLE_BOOKS_API_PART2;
			
			// Call the Google Books API and write our own callback
			// See more details on Google Books API (dynamic links) at http://code.google.com/apis/books/docs/dynamic-links.html
			// Sample ISBNs: 076454280X, 9780307474278
			JSONRequest.get(url, new JSONRequestHandler() {
				public void onRequestComplete (JavaScriptObject json)
				{
					JSONObject jso = new JSONObject(json);

					// Parse the JSON
					String key = "ISBN:" + isbn;
					JSONObject jso1 = jso.get(key).isObject();
					JSONString infoURL = jso1.get("info_url").isString();
					JSONString bookImg = jso1.get("thumbnail_url").isString();
					
					// Generate the output HTML
					String output = "<h2>Book Found</h2><p><img src=" + bookImg + " alt=\"cover\" />";
					output = output + "<p>More information <a href=" + infoURL + " target=\"\">here</a>.";
					result.setHTML(output);
				}
			});
		}
		else {
			result.setText("Invalid ISBN entered.");
		}
		
		// Show result in HTML page inside "result" DIV
		RootPanel.get("results").add(result);
	}
}

package edu.tufts.cs.simplemaps.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.ui.RootPanel;

public class SimpleMaps implements EntryPoint
{
	private MapWidget map;

	// GWT module entry point method.
	public void onModuleLoad()
	{
		LatLng fenway = LatLng.newInstance(42.34639,-71.0975);
		
		// Open a map centered on Fenway Park
		map = new MapWidget(fenway, 13); // The larger the number, the larger the zoom
		
		// Set the size of the map
		map.setSize("800px", "600px");
    
		// Add some controls for the zoom level
		map.addControl(new LargeMapControl());
    
		// Add a marker
		map.addOverlay(new Marker(fenway));

		// Add an info window to highlight a point of interest
		map.getInfoWindow().open(map.getCenter(),
				new InfoWindowContent("Fenway Park.  Home of the Boston Red Sox.  <p>Hosted the Sun Life Frozen Fenway Hockey Game on January 8, 2010.  See pictures <a href=\"http://picasaweb.google.com/mchow01/SunLifeFrozenFenwayBUVsBC\">here</a>.</p>"));
		
		// Add the map to the HTML host page
		RootPanel.get("mapsTutorial").add(map);
	}
}

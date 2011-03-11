/**
 * TAB VIEW
 */
package com.sudarmuthu.android.wt.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;

import com.sudarmuthu.android.workouttracker.R;

/**
 * @author "Sudar Muthu (sudarm@)"
 *
 */
public class TabWidget extends TabActivity {

	/* (non-Javadoc)
	 * @see android.app.ActivityGroup#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_layout);

	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
        Bundle bundle = getIntent().getExtras();
        int typeId = bundle.getInt("typeId");

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    // Entry list tab
        intent = new Intent().setClass(this, EntriesListActivity.class).putExtra("typeId", typeId);
	    spec = tabHost.newTabSpec("lists").setIndicator(this.getString(R.string.tab_list),
				res.getDrawable(R.drawable.ic_tab_list)).setContent(intent);
	    tabHost.addTab(spec);

	    getTabWidget().getChildAt(0).setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v) {
	    		Log.v("TEST", "Clicked 0");
	    	}
	    });
	    
	    // Graph tab
	    intent = new Intent().setClass(this, EntriesGraphActivity.class).putExtra("typeId", typeId);
		spec = tabHost.newTabSpec("date").setIndicator(this.getString(R.string.tab_graph),
				res.getDrawable(R.drawable.ic_tab_graph)).setContent(intent);
	    tabHost.addTab(spec);

	    getTabWidget().getChildAt(1).setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v) {
	    		Log.v("TEST", "Clicked 1");
	    	}
	    });
	    
	    
	    // Stats tab
	    intent = new Intent().setClass(this, EntriesStatsActivity.class).putExtra("typeId", typeId);
	    spec = tabHost.newTabSpec("stats").setIndicator(this.getString(R.string.tab_stats),
	                      res.getDrawable(R.drawable.ic_tab_list))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    getTabWidget().getChildAt(2).setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View v) {
	    		Log.v("TEST", "Clicked 2");
	    	}
	    });
	    
	    // set the initial tab
	    tabHost.setCurrentTab(0);
	}
}
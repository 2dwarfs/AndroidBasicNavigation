package com.twdwarfs.navigation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.twdwarfs.android.navigation.R;

/**
 * @author 2dwarfs.com <info@2dwarfs.com>
 */

public class MainActivity extends ActionBarActivity {

	private DrawerLayout mNavLayout;
	private ListView mNavListView;
	private ActionBarDrawerToggle mNavToggle;

	private String[] mTitles = new String[] { "Dwarfs", "Gnomes", "Dragons" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
		mNavListView = (ListView) findViewById(R.id.nav_listView);

		mNavListView.setAdapter(new NavDrawerListAdapter(this, mTitles));

		mNavListView.setOnItemClickListener(new NavItemClickListener());

		mNavToggle = new ActionBarDrawerToggle(this, 
				mNavLayout, 
				R.drawable.ic_navigation_drawer,
				0, 0);

		mNavLayout.setDrawerListener(mNavToggle);
		
		showFragment(DragonFragment.newInstance());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mNavToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mNavToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mNavToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private class NavItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
	}
	
	private void selectItem(int position) {
        mNavListView.setItemChecked(position, true);
        setTitle(mTitles[position]);
        mNavLayout.closeDrawer(mNavListView);
        
        if(position == 0) {
        	showFragment(DwarfFragment.newInstance());
        }
        else if(position == 1) {
        	showFragment(GnomeFragment.newInstance());
        }
        else if(position == 2) {
        	showFragment(DragonFragment.newInstance());
        }
    }
	
	private void showFragment(Fragment fragment) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.fragment_container, fragment);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.addToBackStack(null);
		ft.commit();
	}
}

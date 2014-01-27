
package com.twdwarfs.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author 2dwarfs.com <info@2dwarfs.com>
 */

public abstract class AbstractFragment extends Fragment {
	
	private ActionBar mActionBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mActionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
		prepare();
	}
	
	public void prepare() {
		if(mActionBar != null) {
			mActionBar.setDisplayHomeAsUpEnabled(true);
			mActionBar.setHomeButtonEnabled(true);
		}
	}
	
	public void setTitle(String title) {
		if(mActionBar != null) {
			mActionBar.setTitle(title);
		}
	}
	
	public void show() {
		
	}
}

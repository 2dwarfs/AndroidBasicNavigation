
package com.twdwarfs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twdwarfs.android.navigation.R;

/**
 * @author 2dwarfs.com <info@2dwarfs.com>
 */

public class GnomeFragment extends AbstractFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_gnome, null);
		
		return v;
	}
	
	public static GnomeFragment newInstance() {
		return new GnomeFragment();
	}
}

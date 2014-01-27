package com.twdwarfs.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.twdwarfs.android.navigation.R;

/**
 * @author 2dwarfs.com <info@2dwarfs.com>
 */

public class NavDrawerListAdapter extends BaseAdapter {

	private Context mContext;
	private String[] mNavDrawerItems;

	public NavDrawerListAdapter(Context context, String[] navDrawerItems) {
		mContext = context;
		mNavDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return mNavDrawerItems.length;
	}

	@Override
	public Object getItem(int position) {       
		return mNavDrawerItems[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = LayoutInflater.from(mContext);
			convertView = mInflater.inflate(R.layout.nav_item, null);
		}
		
		TextView navItemTextView = (TextView) convertView.findViewById(
				R.id.nav_item_title);
		String title = mNavDrawerItems[position];
		navItemTextView.setText(title);
		int resId = R.drawable.dwarfs_icon;
		
		if(position == 0) {
			resId = R.drawable.dwarfs_icon;
		}
		else if(position == 1) {
			resId = R.drawable.gnome_icon;
		}
		else if(position == 2) {
			resId = R.drawable.dragons_icon;
		}
		
		navItemTextView.setCompoundDrawablesWithIntrinsicBounds(
				resId, 0, 0, 0);
		
		return convertView;
	}
}

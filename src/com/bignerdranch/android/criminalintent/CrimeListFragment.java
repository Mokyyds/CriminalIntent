package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DateSorter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {
	private ArrayList<Crime> mCrimes;
	
	private static final String TAG = "CrimeListFragment";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crime_title);
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		
//		ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1,mCrimes);
//		setListAdapter(adapter);
		CrimeAdapter adapter = new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
//		Crime c = (Crime) (getListAdapter()).getItem(position);
		Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);
		Log.d(TAG, c.getmTitle()+" was clicked");
	}
	private class CrimeAdapter extends ArrayAdapter<Crime>{
		public CrimeAdapter(ArrayList<Crime> crimes){
			super(getActivity(), 0,crimes);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
				
			}
			Crime c = getItem(position);
			
			TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTextView.setText(c.getmTitle());
			TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(c.getmDate().toString());
			CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(c.ismSolved());
			return convertView;
		}
	}
}

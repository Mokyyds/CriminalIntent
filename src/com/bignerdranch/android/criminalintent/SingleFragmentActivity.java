package com.bignerdranch.android.criminalintent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class SingleFragmentActivity extends FragmentActivity{
	protected abstract Fragment createFragment();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
        
        FragmentManager fm = getFragmentManager();
        Fragment fragement = fm.findFragmentById(R.id.fragmentContainer);
        
        if (fragement == null) {
			fragement = createFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragement).commit();
			
		}
	}

}

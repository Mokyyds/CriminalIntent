package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class CrimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        
        FragmentManager fm = getFragmentManager();
        Fragment fragement = fm.findFragmentById(R.id.fragmentContainer);
        
        if (fragement == null) {
			fragement = new CrimeFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragement).commit();
			
		}
    }

}

package com.ekranac.root.mathapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {
    TextView calculatorOne;

    SectionsPagerAdapter mSectionsPagerAdapter;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setCurrentItem(1); // Sets fragment with index 1 when index starts
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Switch between fragments based on positon
        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    return new CalculatorFragment();
                case 1:
                    return new PlaceholderFragment();
                case 2:
                    return new CalculatorFragment();
            }
            return null;
        }

        // Number of pages
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        // Page/ fragment title
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }




    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        private ArrayAdapter<String> mAdapter; // Predefined ArrayAdapter


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Raw data
            String[] forecastArray=
                    {
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek"
                    };

            // Transforms raw data from Array to ArrayList so it can be implemented to adapter later
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));


            // Adapter set
            mAdapter = new ArrayAdapter<String>(
                    // Get context of the activity
                    getActivity(),
                    // List item layout
                    R.layout.list_item,
                    // ID of the TextView to populate
                    R.id.list_item_textview,
                    // ArrayList data
                    weekForecast
            );


            ListView listView = (ListView) rootView.findViewById(R.id.listview_main);
            listView.setAdapter(mAdapter);

            return rootView;
        }
    }


    public static class CalculatorFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

            return rootView;
        }
    }


}

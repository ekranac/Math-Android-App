package com.ekranac.root.mathapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends Activity {

    SectionsPagerAdapter mSectionsPagerAdapter;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Removes title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

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


    public static class CalculatorFragment extends Fragment implements View.OnClickListener {
        TextView calcZero,calcOne,calcTwo,calcThree,calcFour,calcFive,calcSix,calcSeven,calcEight,calcNine,
                 calcClear, calcDisplay, calcPoint;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

            calcDisplay = (TextView) rootView.findViewById(R.id.display_content);


            calcOne = (TextView) rootView.findViewById(R.id.calculator_one);
            calcOne.setOnClickListener(this);

            calcTwo = (TextView) rootView.findViewById(R.id.calculator_two);
            calcTwo.setOnClickListener(this);

            calcThree = (TextView) rootView.findViewById(R.id.calculator_three);
            calcThree.setOnClickListener(this);

            calcFour = (TextView) rootView.findViewById(R.id.calculator_four);
            calcFour.setOnClickListener(this);

            calcFive = (TextView) rootView.findViewById(R.id.calculator_five);
            calcFive.setOnClickListener(this);

            calcSix = (TextView) rootView.findViewById(R.id.calculator_six);
            calcSix.setOnClickListener(this);

            calcSeven = (TextView) rootView.findViewById(R.id.calculator_seven);
            calcSeven.setOnClickListener(this);

            calcEight = (TextView) rootView.findViewById(R.id.calculator_eight);
            calcEight.setOnClickListener(this);

            calcNine = (TextView) rootView.findViewById(R.id.calculator_nine);
            calcNine.setOnClickListener(this);

            calcZero = (TextView) rootView.findViewById(R.id.calculator_zero);
            calcZero.setOnClickListener(this);

            calcClear = (TextView) rootView.findViewById(R.id.calculator_clear);
            calcClear.setOnClickListener(this);

            calcPoint = (TextView) rootView.findViewById(R.id.calculator_point);
            calcPoint.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View v)
        {

            String currentContent = null;
            String newContent= null;
            switch(v.getId())
            {
                case R.id.calculator_one:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '1';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_two:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '2';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_three:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '3';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_four:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '4';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_five:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '5';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_six:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '6';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_seven:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '7';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_eight:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '8';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_nine:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '9';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_zero:
                    currentContent = calcDisplay.getText().toString();
                    newContent = currentContent + '0';

                    calcDisplay.setText(newContent);
                    break;

                case R.id.calculator_clear:
                    calcDisplay.setText("");
                    break;

                case R.id.calculator_point:
                    currentContent = calcDisplay.getText().toString();
                    if(currentContent.contains("."))
                    {
                        Log.i("Vejica", "Jp");
                        calcDisplay.setText(currentContent);
                    }
                    else
                    {
                        newContent = currentContent + '.';

                        Log.i("Vejica", "Nope");
                        calcDisplay.setText(newContent);
                        break;
                    }

            }
        }
    }


}

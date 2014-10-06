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
                 calcClear, calcDisplay, calcPoint, calcEquals;
        TextView calcPlus, calcMinus, calcDivide, calcTimes;
        String operatorIs;
        Double numOne, numTwo, result;



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

            numOne=0.0;
            numTwo=0.0;

            operatorIs="";

            calcDisplay = (TextView) rootView.findViewById(R.id.display_content);
            calcDisplay.setText("0");

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

            calcEquals = (TextView) rootView.findViewById(R.id.calculator_equals);
            calcEquals.setOnClickListener(this);

            // Operators


            calcPlus = (TextView) rootView.findViewById(R.id.calculator_add);
            calcPlus.setOnClickListener(this);

            calcMinus = (TextView) rootView.findViewById(R.id.calculator_subtract);
            calcMinus.setOnClickListener(this);

            calcDivide = (TextView) rootView.findViewById(R.id.calculator_divide);
            calcDivide.setOnClickListener(this);

            calcTimes = (TextView) rootView.findViewById(R.id.calculator_multiply);
            calcTimes.setOnClickListener(this);

            return rootView;
        }


        // When calculator numbers are pressed
        public void calcNumClick(int num)
        {
            String oldCalcDisplay = calcDisplay.getText().toString();
            if(num!=0)
            {
                if(oldCalcDisplay=="0")
                {
                    calcDisplay.setText("");
                    oldCalcDisplay="";
                }
                String newCalcDisplay = oldCalcDisplay + Integer.toString(num);
                calcDisplay.setText(newCalcDisplay);

                numTwo = Double.parseDouble(newCalcDisplay);
            }
            if(num==0)
            {
                if(oldCalcDisplay=="0")
                {
                    calcDisplay.setText(oldCalcDisplay);
                }
                else
                {
                    String newCalcDisplay = oldCalcDisplay + Integer.toString(num);
                    calcDisplay.setText(newCalcDisplay);

                    numTwo = Double.parseDouble(newCalcDisplay);
                }
            }

        }


        @Override
        public void onClick(View v)
        {

            switch(v.getId())
            {
                case R.id.calculator_one:
                    calcNumClick(1);
                    break;

                case R.id.calculator_two:
                    calcNumClick(2);
                    break;

                case R.id.calculator_three:
                    calcNumClick(3);
                    break;

                case R.id.calculator_four:
                    calcNumClick(4);
                    break;

                case R.id.calculator_five:
                    calcNumClick(5);
                    break;

                case R.id.calculator_six:
                    calcNumClick(6);
                    break;

                case R.id.calculator_seven:
                    calcNumClick(7);
                    break;

                case R.id.calculator_eight:
                    calcNumClick(8);
                    break;

                case R.id.calculator_nine:
                    break;

                case R.id.calculator_zero:
                    calcNumClick(0);
                    break;

                case R.id.calculator_clear:
                    calcDisplay.setText("0");
                    numOne=0.0;
                    numTwo=0.0;
                    result=0.0;
                    break;

                case R.id.calculator_point:
                    String currentContent = calcDisplay.getText().toString();
                    if(currentContent.contains("."))
                    {
                        calcDisplay.setText(currentContent);
                    }
                    else
                    {
                        String newContent = currentContent + '.';

                        calcDisplay.setText(newContent);
                    }
                    break;



                case R.id.calculator_add:
                    operatorIs="plus";
                    if(numOne==0)
                    {
                        numOne += numTwo;
                    }
                    else if(result!=0.0)
                    {
                        numOne=result;
                    }
                    else
                    {
                        numOne += numTwo;
                    }
                    numTwo=0.0;
                    calcDisplay.setText("");
                    Log.i("Num One", Double.toString(numOne));
                    Log.i("Num Two", Double.toString(numTwo));
                    break;
                case R.id.calculator_subtract:
                    operatorIs="minus";
                    if(numOne==0)
                    {
                        numOne += numTwo;
                    }
                    else if(result!=0.0)
                    {
                        numOne=result;
                    }
                    else
                    {
                        numOne -= numTwo;
                    }
                    numTwo=0.0;
                    calcDisplay.setText("");
                    Log.i("Num One", Double.toString(numOne));
                    Log.i("Num Two", Double.toString(numTwo));
                    break;
                case R.id.calculator_divide:
                    operatorIs="divide";
                    if(numOne==0)
                    {
                        numOne += numTwo;
                    }
                    else if(result!=0.0)
                    {
                        numOne=result;
                    }
                    else
                    {
                        numOne /= numTwo;
                    }
                    numTwo=0.0;
                    calcDisplay.setText("");
                    Log.i("Num One", Double.toString(numOne));
                    Log.i("Num Two", Double.toString(numTwo));
                    break;
                case R.id.calculator_multiply:
                    operatorIs="multiply";
                    if(numOne==0)
                    {
                        numOne += numTwo;
                    }
                    else if(result!=0.0)
                    {
                        numOne=result;
                    }
                    else
                    {
                        numOne *= numTwo;
                    }
                    numTwo=0.0;
                    calcDisplay.setText("");
                    Log.i("Num One", Double.toString(numOne));
                    Log.i("Num Two", Double.toString(numTwo));
                    break;


                case R.id.calculator_equals:
                    if(operatorIs=="plus")
                    {
                        result = numOne+numTwo;
                        calcDisplay.setText(Double.toString(result));

                        numOne=result;
                        numTwo=0.0;
                    }
                    if(operatorIs=="minus")
                    {
                        result = numOne-numTwo;
                        calcDisplay.setText(Double.toString(result));

                        numOne=result;

                    }
                    if(operatorIs=="divide")
                    {
                        result = numOne/numTwo;
                        calcDisplay.setText(Double.toString(result));

                        numOne=result;

                    }
                    if(operatorIs=="multiply")
                    {
                        result = numOne*numTwo;
                        calcDisplay.setText(Double.toString(result));

                        numOne=result;

                    }
                    Log.i("Result",Double.toString(result));
                    break;
            }
        }
    }


}
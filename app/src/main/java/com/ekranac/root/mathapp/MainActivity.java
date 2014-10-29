package com.ekranac.root.mathapp;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import org.xml.sax.Parser;


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

        mViewPager.setCurrentItem(1); // Sets fragment with index 1 when application starts
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Switch between fragments based on positon
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CalculatorFragment();
                case 1:
                    return new PlaceholderFragment();
                case 2:
                    return new CaseFragment();
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
            String[] forecastArray =
                    {
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
                            "Burek",
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
            List<String> arrayList = new ArrayList<String>(Arrays.asList(forecastArray));


            // Adapter set
            mAdapter = new ArrayAdapter<String>(
                    // Get context of the activity
                    getActivity(),
                    // List item layout
                    R.layout.list_item,
                    // ID of the TextView to populate
                    R.id.list_item_textview,
                    // ArrayList data
                    arrayList
            );


            ListView listView = (ListView) rootView.findViewById(R.id.listview_main);
            listView.setAdapter(mAdapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (((TextView) view).getText().toString() == "Burek") {
                        ((TextView) view).startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out));
                        ((TextView) view).setText("Hey!");
                        ((TextView) view).startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));
                    } else {
                        ((TextView) view).startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out));
                        ((TextView) view).setText("Burek");
                        ((TextView) view).startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));
                    }
                }
            });

            return rootView;
        }

    }


    public static class CalculatorFragment extends Fragment implements View.OnClickListener{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Button calcZero, calcOne, calcTwo, calcThree, calcFour, calcFive, calcSix, calcSeven, calcEight, calcNine,
                    calcClear, calcPoint, calcPlus, calcMinus, calcTimes, calcDivide, calcEquals;
            EditText calcDisplay, oldCalcDisplay;



            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);


            calcDisplay = (EditText) rootView.findViewById(R.id.display_content);
            calcDisplay.setText("0");

            oldCalcDisplay = (EditText) rootView.findViewById(R.id.display_old_content);
            oldCalcDisplay.setText("");


            calcZero = (Button) rootView.findViewById(R.id.calculator_zero);
            calcZero.setOnClickListener(this);

            calcOne = (Button) rootView.findViewById(R.id.calculator_one);
            calcOne.setOnClickListener(this);

            calcTwo = (Button) rootView.findViewById(R.id.calculator_two);
            calcTwo.setOnClickListener(this);

            calcThree = (Button) rootView.findViewById(R.id.calculator_three);
            calcThree.setOnClickListener(this);

            calcFour = (Button) rootView.findViewById(R.id.calculator_four);
            calcFour.setOnClickListener(this);

            calcFive = (Button) rootView.findViewById(R.id.calculator_five);
            calcFive.setOnClickListener(this);

            calcSix = (Button) rootView.findViewById(R.id.calculator_six);
            calcSix.setOnClickListener(this);

            calcSeven = (Button) rootView.findViewById(R.id.calculator_seven);
            calcSeven.setOnClickListener(this);

            calcEight = (Button) rootView.findViewById(R.id.calculator_eight);
            calcEight.setOnClickListener(this);

            calcNine = (Button) rootView.findViewById(R.id.calculator_nine);
            calcNine.setOnClickListener(this);



            calcClear = (Button) rootView.findViewById(R.id.calculator_clear);
            calcClear.setOnClickListener(this);

            calcPoint = (Button) rootView.findViewById(R.id.calculator_point);
            calcPoint.setOnClickListener(this);

            calcMinus = (Button) rootView.findViewById(R.id.calculator_subtract);
            calcMinus.setOnClickListener(this);

            calcTimes = (Button) rootView.findViewById(R.id.calculator_multiply);
            calcTimes.setOnClickListener(this);

            calcDivide = (Button) rootView.findViewById(R.id.calculator_divide);
            calcDivide.setOnClickListener(this);

            calcPlus = (Button) rootView.findViewById(R.id.calculator_add);
            calcPlus.setOnClickListener(this);

            calcEquals = (Button) rootView.findViewById(R.id.calculator_equals);
            calcEquals.setOnClickListener(this);

            return rootView;
        }


        ArrayList<String> equ = new ArrayList<String>();
        Boolean hasPoint=false;

        @Override
        public void onPause()
        {
            super.onPause();

            EditText calcDisplay = (EditText) getActivity().findViewById(R.id.display_content);
            calcDisplay.setText("0");

            equ.clear();

        }

        // ADD OPERATOR ONCLICKLISTENERS & EVENTS... POINT CHECK, DISPLAY ON OLDCALCDISPLAY
        public void numClick(int num, EditText calcDisplay)
        {

            if(num!=0)
            {
                if (Double.parseDouble(calcDisplay.getText().toString()) == 0.0)
                {
                    calcDisplay.setText("");
                }


                calcDisplay.setText(calcDisplay.getText().toString() + Integer.toString(num));
                equ.add(Integer.toString(num));
            }

            else if(num==0)
            {
                if (Double.parseDouble(calcDisplay.getText().toString()) == 0.0)
                {
                    calcDisplay.setText(calcDisplay.getText().toString());
                }
                else
                {
                    calcDisplay.setText(calcDisplay.getText().toString() + Integer.toString(num));
                    equ.add(Integer.toString(num));
                }
            }




            for(int i = 0; i<equ.size()-1; i++)
            {
                Log.i("Num", equ.get(i));
            }
        }

        public void addOperator(String op, EditText calcDisplay, EditText oldCalcDisplay)
        {

            if(equ.size()==0)
            {
                calcDisplay.setText("0");
            }
            else if(equ.get(equ.size()-1)=="÷" || equ.get(equ.size()-1)=="-" || equ.get(equ.size()-1)=="+" || equ.get(equ.size()-1)=="×")
            {
                equ.remove(equ.size() -1);
                oldCalcDisplay.setText(oldCalcDisplay.getText().toString().substring(0, oldCalcDisplay.getText().toString().length()-1));

                equ.add(op);
                oldCalcDisplay.setText(oldCalcDisplay.getText().toString() + op);
            }
            else
            {
                equ.add(op);

                oldCalcDisplay.setText(oldCalcDisplay.getText().toString() + calcDisplay.getText().toString() + op);
                calcDisplay.setText("0");
            }
            hasPoint=false;
        }


        @Override
        public void onClick(View v)
        {

            EditText calcDisplay = (EditText) getActivity().findViewById(R.id.display_content);
            EditText oldCalcDisplay = (EditText) getActivity().findViewById(R.id.display_old_content);

            switch(v.getId())
            {
                case R.id.calculator_zero:
                    numClick(0, calcDisplay);
                    break;
                case R.id.calculator_one:
                    numClick(1, calcDisplay);
                    break;
                case R.id.calculator_two:
                    numClick(2, calcDisplay);
                    break;
                case R.id.calculator_three:
                    numClick(3, calcDisplay);
                    break;
                case R.id.calculator_four:
                    numClick(4, calcDisplay);
                    break;
                case R.id.calculator_five:
                    numClick(5, calcDisplay);
                    break;
                case R.id.calculator_six:
                    numClick(6, calcDisplay);
                    break;
                case R.id.calculator_seven:
                    numClick(7,calcDisplay);
                    break;
                case R.id.calculator_eight:
                    numClick(8, calcDisplay);
                    break;
                case R.id.calculator_nine:
                    numClick(9, calcDisplay);
                    break;


                case R.id.calculator_clear:
                    equ.clear();
                    calcDisplay.setText("0");
                    oldCalcDisplay.setText("");
                    hasPoint = false;
                    break;

                case R.id.calculator_point:
                    if(!hasPoint)
                    {
                        equ.add(".");
                        calcDisplay.setText(calcDisplay.getText().toString() + ".");

                        hasPoint=true;
                    }
                    break;

                case R.id.calculator_add:
                    addOperator("+", calcDisplay, oldCalcDisplay);
                    break;

                case R.id.calculator_subtract:
                    addOperator("-", calcDisplay, oldCalcDisplay);
                    break;

                case R.id.calculator_divide:
                    addOperator("÷", calcDisplay, oldCalcDisplay);
                    break;

                case R.id.calculator_multiply:
                    addOperator("×", calcDisplay, oldCalcDisplay);
                    break;

                case R.id.calculator_equals:
                    String equation = oldCalcDisplay.getText().toString() + calcDisplay.getText().toString();
                    Log.i("Result", equation);
                    // Need to find a way to convert string to a math expression !
                    break;


            }
        }



    }



    public static class CaseFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_case, container, false);

            return rootView;
        }
    }

}
package com.ekranac.root.mathapp.activities;

import java.util.ArrayList;
import java.util.Locale;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ekranac.root.mathapp.R;
import helpers.CalculatorHelper;

import bsh.EvalError;
import bsh.Interpreter;


public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "";


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

        // Switch between fragments based on position
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CalculatorFragment();
                case 1:
                    return new MainFragment();
            }
            return null;
        }

        // Number of pages
        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
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


    public static class MainFragment extends Fragment implements View.OnClickListener {
        private static final String ARG_SECTION_NUMBER = "section_number";

        private ArrayAdapter<String> mAdapter; // Predefined ArrayAdapter

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);


            RelativeLayout layout_one = (RelativeLayout) rootView.findViewById(R.id.icon_one);
            ImageButton icon_one = (ImageButton) rootView.findViewById(R.id.imageButton1);
            TextView text_one = (TextView) rootView.findViewById(R.id.a_text);
            layout_one.setOnClickListener(this);
            icon_one.setOnClickListener(this);
            text_one.setOnClickListener(this);

            RelativeLayout layout_two = (RelativeLayout) rootView.findViewById(R.id.icon_two);
            ImageButton icon_two = (ImageButton) rootView.findViewById(R.id.imageButton2);
            TextView text_two = (TextView) rootView.findViewById(R.id.b_text);
            layout_two.setOnClickListener(this);
            icon_two.setOnClickListener(this);
            text_two.setOnClickListener(this);

            RelativeLayout layout_three = (RelativeLayout) rootView.findViewById(R.id.icon_three);
            ImageButton icon_three = (ImageButton) rootView.findViewById(R.id.imageButton3);
            TextView text_three = (TextView) rootView.findViewById(R.id.c_text);
            layout_three.setOnClickListener(this);
            icon_three.setOnClickListener(this);
            text_three.setOnClickListener(this);

            RelativeLayout layout_four = (RelativeLayout) rootView.findViewById(R.id.icon_four);
            ImageButton icon_four = (ImageButton) rootView.findViewById(R.id.imageButton4);
            TextView text_four = (TextView) rootView.findViewById(R.id.d_text);
            layout_four.setOnClickListener(this);
            icon_four.setOnClickListener(this);
            text_four.setOnClickListener(this);

            RelativeLayout layout_five = (RelativeLayout) rootView.findViewById(R.id.icon_five);
            ImageButton icon_five = (ImageButton) rootView.findViewById(R.id.imageButton5);
            TextView text_five = (TextView) rootView.findViewById(R.id.e_text);
            layout_five.setOnClickListener(this);
            icon_five.setOnClickListener(this);
            text_five.setOnClickListener(this);

            RelativeLayout layout_six = (RelativeLayout) rootView.findViewById(R.id.icon_six);
            ImageButton icon_six = (ImageButton) rootView.findViewById(R.id.imageButton6);
            TextView text_six = (TextView) rootView.findViewById(R.id.f_text);
            layout_six.setOnClickListener(this);
            icon_six.setOnClickListener(this);
            text_six.setOnClickListener(this);

            RelativeLayout layout_seven = (RelativeLayout) rootView.findViewById(R.id.icon_seven);
            ImageButton icon_seven = (ImageButton) rootView.findViewById(R.id.imageButton7);
            TextView text_seven = (TextView) rootView.findViewById(R.id.g_text);
            layout_seven.setOnClickListener(this);
            icon_seven.setOnClickListener(this);
            text_seven.setOnClickListener(this);

            RelativeLayout layout_eight = (RelativeLayout) rootView.findViewById(R.id.icon_eight);
            ImageButton icon_eight = (ImageButton) rootView.findViewById(R.id.imageButton8);
            TextView text_eight = (TextView) rootView.findViewById(R.id.h_text);
            layout_eight.setOnClickListener(this);
            icon_eight.setOnClickListener(this);
            text_eight.setOnClickListener(this);

            RelativeLayout layout_nine = (RelativeLayout) rootView.findViewById(R.id.icon_nine);
            ImageButton icon_nine = (ImageButton) rootView.findViewById(R.id.imageButton9);
            TextView text_nine = (TextView) rootView.findViewById(R.id.i_text);
            layout_nine.setOnClickListener(this);
            icon_nine.setOnClickListener(this);
            text_nine.setOnClickListener(this);

            RelativeLayout layout_ten = (RelativeLayout) rootView.findViewById(R.id.icon_ten);
            ImageButton icon_ten = (ImageButton) rootView.findViewById(R.id.imageButton10);
            TextView text_ten = (TextView) rootView.findViewById(R.id.j_text);
            layout_ten.setOnClickListener(this);
            icon_ten.setOnClickListener(this);
            text_ten.setOnClickListener(this);

            return rootView;
        }

        public void iconClick(View view)
        {
            ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.8f);
            ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(view, "alpha", 0.8f, 1);

            animator.setDuration(1000);
            animator.start();


            secondAnimator.setDuration(1000);
            secondAnimator.start();


            String random = "random";
            Intent intent = new Intent(getActivity(), ListActivity.class);
            intent.putExtra(EXTRA_MESSAGE, random);
            startActivity(intent);
        }

        @Override
        public void onClick(View v)
        {

            RelativeLayout layout_one = (RelativeLayout) getActivity().findViewById(R.id.icon_one);
            RelativeLayout layout_two = (RelativeLayout) getActivity().findViewById(R.id.icon_two);
            RelativeLayout layout_three = (RelativeLayout) getActivity().findViewById(R.id.icon_three);
            RelativeLayout layout_four = (RelativeLayout) getActivity().findViewById(R.id.icon_four);
            RelativeLayout layout_five = (RelativeLayout) getActivity().findViewById(R.id.icon_five);
            RelativeLayout layout_six = (RelativeLayout) getActivity().findViewById(R.id.icon_six);
            RelativeLayout layout_seven = (RelativeLayout) getActivity().findViewById(R.id.icon_seven);
            RelativeLayout layout_eight = (RelativeLayout) getActivity().findViewById(R.id.icon_eight);
            RelativeLayout layout_nine = (RelativeLayout) getActivity().findViewById(R.id.icon_nine);
            RelativeLayout layout_ten = (RelativeLayout) getActivity().findViewById(R.id.icon_ten);

            switch(v.getId())
            {
                case R.id.icon_one:
                    iconClick(layout_one);
                    break;
                case R.id.imageButton1:
                    iconClick(layout_one);
                    break;
                case R.id.a_text:
                    iconClick(layout_two);
                    break;
                case R.id.icon_two:
                    iconClick(layout_two);
                    break;
                case R.id.imageButton2:
                    iconClick(layout_two);
                    break;
                case R.id.b_text:
                    iconClick(layout_two);
                    break;
                case R.id.icon_three:
                    iconClick(layout_three);
                    break;
                case R.id.imageButton3:
                    iconClick(layout_three);
                    break;
                case R.id.c_text:
                    iconClick(layout_three);
                    break;
                case R.id.icon_four:
                    iconClick(layout_four);
                    break;
                case R.id.imageButton4:
                    iconClick(layout_four);
                    break;
                case R.id.d_text:
                    iconClick(layout_four);
                    break;
                case R.id.icon_five:
                    iconClick(layout_five);
                    break;
                case R.id.imageButton5:
                    iconClick(layout_five);
                    break;
                case R.id.e_text:
                    iconClick(layout_five);
                    break;
                case R.id.icon_six:
                    iconClick(layout_six);
                    break;
                case R.id.imageButton6:
                    iconClick(layout_six);
                    break;
                case R.id.f_text:
                    iconClick(layout_six);
                    break;
                case R.id.icon_seven:
                    iconClick(layout_seven);
                    break;
                case R.id.imageButton7:
                    iconClick(layout_seven);
                    break;
                case R.id.g_text:
                    iconClick(layout_seven);
                    break;
                case R.id.icon_eight:
                    iconClick(layout_eight);
                    break;
                case R.id.imageButton8:
                    iconClick(layout_eight);
                    break;
                case R.id.h_text:
                    iconClick(layout_eight);
                    break;
                case R.id.icon_nine:
                    iconClick(layout_nine);
                    break;
                case R.id.imageButton9:
                    iconClick(layout_nine);
                    break;
                case R.id.i_text:
                    iconClick(layout_nine);
                    break;
                case R.id.icon_ten:
                    iconClick(layout_ten);
                    break;
                case R.id.imageButton10:
                    iconClick(layout_ten);
                    break;
                case R.id.j_text:
                    iconClick(layout_ten);
                    break;
            }
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

            calcClear.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Vibrator vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    equ.clear();
                    return false;

                }
            });

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


        Boolean hasPoint=false;
        ArrayList<String> equ = new ArrayList<String>();

        @Override
        public void onPause()
        {
            super.onPause();

            EditText calcDisplay = (EditText) getActivity().findViewById(R.id.display_content);
            calcDisplay.setText("0");

            equ.clear();


        }



        @Override
        public void onClick(View v)
        {

            EditText calcDisplay = (EditText) getActivity().findViewById(R.id.display_content);
            EditText oldCalcDisplay = (EditText) getActivity().findViewById(R.id.display_old_content);

            switch(v.getId())
            {
                case R.id.calculator_zero:
                    CalculatorHelper.numClick(0, calcDisplay, equ);
                    break;
                case R.id.calculator_one:
                    CalculatorHelper.numClick(1, calcDisplay, equ);
                    break;
                case R.id.calculator_two:
                    CalculatorHelper.numClick(2, calcDisplay, equ);
                    break;
                case R.id.calculator_three:
                    CalculatorHelper.numClick(3, calcDisplay, equ);
                    break;
                case R.id.calculator_four:
                    CalculatorHelper.numClick(4, calcDisplay, equ);
                    break;
                case R.id.calculator_five:
                    CalculatorHelper.numClick(5, calcDisplay, equ);
                    break;
                case R.id.calculator_six:
                    CalculatorHelper.numClick(6, calcDisplay, equ);
                    break;
                case R.id.calculator_seven:
                    CalculatorHelper.numClick(7, calcDisplay, equ);
                    break;
                case R.id.calculator_eight:
                    CalculatorHelper.numClick(8, calcDisplay, equ);
                    break;
                case R.id.calculator_nine:
                    CalculatorHelper.numClick(9, calcDisplay, equ);
                    break;

                case R.id.calculator_clear:
                    if(equ.size()==0)
                    {
                        calcDisplay.setText("0");
                    }
                    else if(equ.size()!=1 && calcDisplay.getText().toString()!="0")
                    {
                        equ.remove(equ.size()-1);
                        calcDisplay.setText(calcDisplay.getText().toString().substring(0, calcDisplay.getText().toString().length() - 1));
                    }
                    else
                    {
                        calcDisplay.setText("0");
                        equ.clear();
                    }
                    /*equ.clear();
                    calcDisplay.setText("0");
                    oldCalcDisplay.setText("");
                    hasPoint = false;*/
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
                    CalculatorHelper.addOperator("+", calcDisplay, oldCalcDisplay, equ);
                    hasPoint=false;
                    break;

                case R.id.calculator_subtract:
                    CalculatorHelper.addOperator("-", calcDisplay, oldCalcDisplay, equ);
                    hasPoint=false;
                    break;

                case R.id.calculator_divide:
                    CalculatorHelper.addOperator("÷", calcDisplay, oldCalcDisplay, equ);
                    hasPoint=false;
                    break;

                case R.id.calculator_multiply:
                    CalculatorHelper.addOperator("×", calcDisplay, oldCalcDisplay, equ);
                    hasPoint=false;
                    break;

                case R.id.calculator_equals:
                    String equation = oldCalcDisplay.getText().toString() + calcDisplay.getText().toString();
                    equation = equation.replace("×","*");
                    equation = equation.replace("÷","/");
                    if(!equation.contains("."))
                    {
                        equation = equation + ".";
                    }

                    try {
                        String finalResult = "";
                        Interpreter interpreter = new Interpreter();
                        interpreter.eval("result = " + equation);

                        double dFinalResult = Double.valueOf(interpreter.get("result").toString());

                        if(dFinalResult % 1==0)
                        {
                            finalResult = Double.toString(dFinalResult).replace(".0","");
                        }
                        else
                        {
                            finalResult = Double.toString(dFinalResult);
                        }

                        calcDisplay.setText(finalResult);
                        oldCalcDisplay.setText("");
                        equ.clear();

                    }

                    catch (EvalError error)
                    {
                        Log.i("EvalError", error.toString());
                    }


                    // Need to find a way to convert string to a math expression !
                    // Found the way, motherfucker #prodigy
                    break;


            }
        }

    }

}
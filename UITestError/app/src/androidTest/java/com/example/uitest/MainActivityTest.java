package com.example.uitest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.uitest.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeText_sameActivity() {
        String mStringToBetyped = "apolis batch 18";
        //select edittext
        onView(withId(R.id.editText))
        //enter abdul in it
        .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        //click the button
        onView(withId(R.id.buttonLogin)).perform(click());
        //verify if the textview has abdul
        onView(withId(R.id.textViewResult))
                .check(matches(withText(mStringToBetyped)));

    }

}
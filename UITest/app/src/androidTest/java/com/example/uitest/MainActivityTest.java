package com.example.uitest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.editText)).perform(typeText("Cal"), closeSoftKeyboard());
        onView(withId(R.id.checkBox)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Cal Check me")));
    }

    @Test
    public void changeText_sameActivity2() {
        onView(withId(R.id.editText)).perform(typeText("Cal"), closeSoftKeyboard());
        onView(withId(R.id.checkBox)).perform(click());
        onView(withId(R.id.checkBox)).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Cal")));
    }

}

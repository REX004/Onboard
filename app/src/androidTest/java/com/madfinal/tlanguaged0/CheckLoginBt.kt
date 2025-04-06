package com.madfinal.tlanguaged0


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CheckLoginBt {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkLoginBt() {
        val materialButton = onView(
            allOf(
                withId(R.id.nextBt), withText("next"),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val materialTextView = onView(
            allOf(
                withId(R.id.loginBt), withText("login Bt"),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.nextBt), withText("Next"),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(R.id.nextBt), withText("Next"),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val materialButton4 = onView(
            allOf(
                withId(R.id.nextBt), withText("Sign up"),
                isDisplayed()
            )
        )
        materialButton4.perform(click())

        val materialTextView2 = onView(
            allOf(
                withId(R.id.loginBt), withText("login Bt"),
                isDisplayed()
            )
        )
        materialTextView2.perform(click())
    }
}

package com.madfinal.tlanguaged0


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ImageAndTextTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun imageAndTextTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.nextBt), withText("next"),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val linearLayout = onView(
            allOf(
                withId(R.id.linearLayout),
                withParent(withParent(withId(R.id.navHostFragment))),
                isDisplayed()
            )
        )
        linearLayout.check(matches(isDisplayed()))

        val imageView = onView(
            allOf(
                withId(R.id.image),
                withParent(withParent(withId(R.id.navHostFragment))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val materialButton2 = onView(
            allOf(
                withId(R.id.nextBt), withText("Next"),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val imageView2 = onView(
            allOf(
                withId(R.id.image),
                withParent(withParent(withId(R.id.navHostFragment))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.title), withText("Title2"),
                withParent(
                    allOf(
                        withId(R.id.linearLayout),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Title2")))

        val materialButton3 = onView(
            allOf(
                withId(R.id.nextBt), withText("Next"),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val imageView3 = onView(
            allOf(
                withId(R.id.image),
                withParent(withParent(withId(R.id.navHostFragment))),
                isDisplayed()
            )
        )
        imageView3.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.title), withText("Title3"),
                withParent(
                    allOf(
                        withId(R.id.linearLayout),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Title3")))
    }
}

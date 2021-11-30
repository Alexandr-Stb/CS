package com.example.cs

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test


class FirstTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun firstTest(){
        onView(withId(R.id.recykleView))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(allOf(withId(R.id.text_item),withText("NAVI"))),
                    click())
            )
        onView(
            allOf(withId(R.id.title_player_1), withText("BoombI4"))).check(matches(isDisplayed()))
        onView(
            allOf(withId(R.id.title_player_2), withText("Simple"))).check(matches(isDisplayed()))
        Thread.sleep(2000)
    }
}
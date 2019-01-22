package com.example.richard.oichina

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeRight
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.example.richard.oichina.activity.LessonsActivity
import org.hamcrest.CoreMatchers.allOf

object LessonsActivityRobotConstants {
}

class LessonsActivityPrepara(val activityTestRule: ActivityTestRule<LessonsActivity>) {
    internal fun startActivity() {
        val intent = Intent(Intent.ACTION_PICK)
        activityTestRule.launchActivity(intent)
    }
}

class LessonsActivityExecuta {
    internal fun swipeIsWorking() {
        onView(withId(R.id.viewpager_id)).perform(swipeRight())
    }

    internal fun clickOnARecyclerViewItemIsWorking() {
        onView(allOf(withId(R.id.rv_basic_lessons), isDescendantOfA(withId(R.id.viewpager_id))))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

    }
}

class LessonsActivityValida {
    internal fun toolbarIsDisplayed() {
        onView(withId(R.id.toolbar_id)).check(matches(isDisplayed()))
    }

    internal fun tabLayoutIsDisplayed() {
        onView(withId(R.id.tabLayout_id)).check(matches(isDisplayed()))
    }
}
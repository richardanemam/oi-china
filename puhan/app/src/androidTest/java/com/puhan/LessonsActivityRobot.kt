package com.puhan

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.puhan.activity.LessonsActivity

object LessonsActivityRobotConstants {
}

class LessonsActivityPrepara(val intentsTestRule: IntentsTestRule<LessonsActivity>) {
    internal fun startActivity() {
        intentsTestRule.launchActivity(null)
    }
}

class LessonsActivityExecuta {

    internal fun clickOnARecyclerViewItemIsWorking() {
        onView(withId(R.id.rv_basic_lessons))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

    }
}

class LessonsActivityValida {
    internal fun toolbarIsDisplayed() {
        onView(withId(R.id.toolbar_id)).check(matches(isDisplayed()))
    }
}
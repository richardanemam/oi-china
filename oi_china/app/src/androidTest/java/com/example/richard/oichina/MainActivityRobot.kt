package com.example.richard.oichina

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.example.richard.oichina.activity.LessonsActivity
import com.example.richard.oichina.activity.MainActivity
import org.hamcrest.CoreMatchers.endsWith
import org.junit.Assert.assertTrue

object MainActivityRobotConstants {
    val LICAO = "Lições"
}

class MainActivityPrepara(val activityTestRule: ActivityTestRule<MainActivity>) {
    internal fun startActivity() {
        val intent = Intent(Intent.ACTION_PICK)
        activityTestRule.launchActivity(intent)
    }
}

class MainActivityExecuta {
    internal fun clickLicoes() {
        onView(withId(R.id.btn_licoes)).perform(click())
    }

    internal fun clickExpressoes() {
        onView(withId(R.id.btn_expressoes)).perform(click())
    }

    internal fun clickSobreOApp() {
        onView(withId(R.id.btn_sobre_o_app)).perform(click())
    }
}

class MainActivityValida(val activityTestRule: ActivityTestRule<MainActivity>) {
    internal fun isFinishingActivity() {
        assertTrue(activityTestRule.activity.isFinishing)
    }

    internal fun checkIntentToLessonsActivity() {
        intended(hasComponent(LessonsActivity::class.java.name))
    }

    internal fun checkToolbarAndItsContent() {
        onView(withId(R.id.toolbar_id)).check(matches(isDisplayed()))
        onView(withText(endsWith("PUHAN 葡汉"))).check(matches(withParent(withId(R.id.cl_toolbar))))
        onView(withText(endsWith("APRENDA MANDARIM"))).check(matches(withParent(withId(R.id.cl_toolbar))))
    }
}

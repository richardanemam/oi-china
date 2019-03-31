package com.example.richard.oichina

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.richard.oichina.activity.LessonsActivity
import com.example.richard.oichina.activity.MainActivity
import org.hamcrest.CoreMatchers.endsWith
import org.junit.Assert.assertTrue

object MainActivityRobotConstants {
    val LICAO = "Lições"
}

class MainActivityPrepara(val intentsTestRule: IntentsTestRule<MainActivity>) {
    internal fun startActivity() {
        intentsTestRule.launchActivity(null)
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

class MainActivityValida(val intentsTestRule: IntentsTestRule<MainActivity>) {
    internal fun isFinishingActivity() {
        assertTrue(intentsTestRule.activity.isFinishing)
    }

    internal fun checkIntentToLessonsActivity() {
        intended(hasComponent(LessonsActivity::class.java.name))
    }

    internal fun checkToolbarAndItsContent() {
        onView(withId(R.id.toolbar_id)).check(matches(isDisplayed()))
        onView(withText(endsWith("PUHAN 葡汉"))).check(matches(withParent(withId(R.id.cl_toolbar))))
        onView(withText(endsWith("A P R E N D A M A N D A R I M"))).check(matches(withParent(withId(R.id.cl_toolbar))))
    }
}

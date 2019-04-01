package com.example.richard.oichina

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.richard.oichina.activity.HomeActivity
import com.example.richard.oichina.activity.LessonsActivity
import org.junit.Assert.assertTrue

object HomeActivityRobotConstants {
    val LICAO = "Lições"
}

class MainActivityPrepara(val intentsTestRule: IntentsTestRule<HomeActivity>) {
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

class MainActivityValida(val intentsTestRule: IntentsTestRule<HomeActivity>) {
    internal fun isFinishingActivity() {
        assertTrue(intentsTestRule.activity.isFinishing)
    }

    internal fun checkIntentToLessonsActivity() {
        intended(hasComponent(LessonsActivity::class.java.name))
    }
}

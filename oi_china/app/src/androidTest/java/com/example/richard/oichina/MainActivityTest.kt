package com.example.richard.oichina

import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.richard.oichina.activity.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun endUp() {
        Intents.release()
    }

    private fun prepara(func: MainActivityPrepara.() -> Unit) =
            MainActivityPrepara(activityTestRule).apply(func)

    private fun executa(func: MainActivityExecuta.() -> Unit) =
            MainActivityExecuta().apply(func)

    private fun valida(func: MainActivityValida.() -> Unit) =
            MainActivityValida(activityTestRule).apply(func)

    @Test
    fun whenClickInLicaoItShouldOpenLicaoActivity() {
        prepara {
            startActivity()
        }
        executa {
            clickLicoes()
        }
        valida {
            checkIntentToLessonsActivity()
        }
    }

    //TODO Test for the Expressions Button
    //TODO Test for the About Button

    @Test
    fun checkToolbarAndItsContent() {
        prepara {
            startActivity()
        }
        valida {
            checkToolbarAndItsContent()
        }
    }
}
package com.example.richard.oichina

import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import com.example.richard.oichina.activity.LessonsActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LessonsActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(LessonsActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun endUp() {
        Intents.release()
    }

    private fun prepara(func: LessonsActivityPrepara.() -> Unit) =
            LessonsActivityPrepara(activityTestRule).apply(func)

    private fun executa(func: LessonsActivityExecuta.() -> Unit) =
            LessonsActivityExecuta().apply(func)

    private fun valida(func: LessonsActivityValida.() -> Unit) =
            LessonsActivityValida().apply(func)

    @Test
    fun checkToolbarWhetherToolbarIsDisplayed() {
        prepara {
            startActivity()
        }
        valida {
            toolbarIsDisplayed()
        }
    }

    @Test
    fun checkWhetherTabLayoutIsDisplayed() {
        prepara {
            startActivity()
        }
        valida {
            tabLayoutIsDisplayed()
        }
    }

    @Test
    fun checkWhetherSwipeIsWorking() {
        prepara {
            startActivity()
        }
        executa {
            swipeIsWorking()
        }
        valida {
            toolbarIsDisplayed()
            tabLayoutIsDisplayed()
        }
    }

    @Test
    fun clickOnARecyclerViewItem() {
        prepara {
            startActivity()
        }
        executa {
            clickOnARecyclerViewItemIsWorking()
        }
        valida {
            toolbarIsDisplayed()
            tabLayoutIsDisplayed()
        }
    }
}
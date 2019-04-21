package com.puhan

import androidx.test.espresso.intent.rule.IntentsTestRule
import com.puhan.activity.LessonsActivity
import org.junit.Rule
import org.junit.Test

class LessonsActivityTest {

    @Rule
    @JvmField
    val intentsTestRule = IntentsTestRule(LessonsActivity::class.java, true, false)

    private fun prepara(func: LessonsActivityPrepara.() -> Unit) =
            LessonsActivityPrepara(intentsTestRule).apply(func)

    private fun executa(func: LessonsActivityExecuta.() -> Unit) =
            LessonsActivityExecuta().apply(func)

    private fun valida(func: LessonsActivityValida.() -> Unit) =
            LessonsActivityValida().apply(func)

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
        }
    }
}
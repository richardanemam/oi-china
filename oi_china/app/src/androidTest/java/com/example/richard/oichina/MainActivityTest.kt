package com.example.richard.oichina

import androidx.test.espresso.intent.rule.IntentsTestRule
import com.example.richard.oichina.activity.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    val intentsTestRule = IntentsTestRule(MainActivity::class.java, true, false)

    private fun prepara(func: MainActivityPrepara.() -> Unit) =
            MainActivityPrepara(intentsTestRule).apply(func)

    private fun executa(func: MainActivityExecuta.() -> Unit) =
            MainActivityExecuta().apply(func)

    private fun valida(func: MainActivityValida.() -> Unit) =
            MainActivityValida(intentsTestRule).apply(func)

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
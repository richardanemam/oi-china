package com.example.richard.oichina

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.richard.oichina.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    fun prepara(func: MainActivityPrepara.() -> Unit) = MainActivityPrepara(activityTestRule).apply { func() }
    fun executa(func: MainActivityExecuta.() -> Unit) = MainActivityExecuta().apply(func)
    fun valida(func: MainActivityValida.() -> Unit) = MainActivityValida(activityTestRule).apply(func)

    @Test
    fun whenClickInLicaoItShouldOpenLicaoActivity() {
        prepara {
            startActivity()
        }
        executa {
            clickLicoes()
        }
        valida {}
    }

    @Test
    fun checkToolbarAndItsContent() {
        prepara {
            startActivity()
        }
        executa {}
        valida {
            checkToolbarAndItsContent()
        }

    }

}
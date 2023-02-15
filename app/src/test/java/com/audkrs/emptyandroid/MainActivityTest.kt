package com.audkrs.emptyandroid

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityUnitTest {

    @Rule(order = 0)
    @JvmField
    val rule = HiltAndroidRule(this)
    @Rule(order = 1)
    @JvmField
    val scenarioRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun name() {
        val scenario = scenarioRule.activityRule.scenario
        scenario.moveToState(Lifecycle.State.RESUMED)

        with(scenarioRule){
            onNodeWithText("Hello world!").assertIsDisplayed()
            onNodeWithText("click me").performClick()
            onNodeWithText("BAZINGA").assertIsDisplayed()
        }
    }
}

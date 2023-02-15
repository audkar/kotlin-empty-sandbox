package com.audkrs.emptyandroid

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @Rule(order = 0)
    @JvmField
    val hiltRule = HiltAndroidRule(this)

    @Rule(order = 1)
    @JvmField
    val scenarioRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun name() {
        with(scenarioRule) {
            onNode(hasText("Hello world!")).assertIsDisplayed()
        }
    }
}

package com.audkrs.emptyandroid

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.audkrs.emptyandroid.main.Bazinga
import com.audkrs.emptyandroid.main.MainScreen
import com.audkrs.emptyandroid.main.SecondaryScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bazinga: Bazinga

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val (helloText, setHelloText) = remember { mutableStateOf("Hello world!") }
            val navScreens: MutableList<NavScreen> = rememberMutableStateListOf(screens = emptyList())
            val navScreen = remember { derivedStateOf { navScreens.lastOrNull() ?: NavScreen.MAIN } }
            val backHandlerEnabled = remember { derivedStateOf { navScreens.size > 0 } }

            MaterialTheme(
                colorScheme = darkColorScheme(),
            ) {
                Scaffold {
                    Column(Modifier.padding(it)) {
                        Text(text = helloText)
                        Button(onClick = { setHelloText(bazinga.haaa()) }) {
                            Text(text = getString(R.string.click_me))
                        }
                        when (navScreen.value) {
                            NavScreen.MAIN -> MainScreen(
                                navigateToSecondary = { navScreens.add(NavScreen.SECONDARY) },
                            )
                            NavScreen.SECONDARY -> SecondaryScreen()
                        }
                    }
                }
            }
            BackHandler(
                enabled = backHandlerEnabled.value,
            ) {
               navScreens.removeLast()
            }
        }
    }
}


@Parcelize
private enum class NavScreen: Parcelable {
    MAIN,
    SECONDARY,
}

@Composable
private fun rememberMutableStateListOf(screens: Collection<NavScreen>): SnapshotStateList<NavScreen> {
    return rememberSaveable(
        saver = listSaver(
            save = { stateList ->
                stateList.toList()
            },
            restore = { it.toMutableStateList() }
        )
    ) {
        screens.toList().toMutableStateList()
    }
}
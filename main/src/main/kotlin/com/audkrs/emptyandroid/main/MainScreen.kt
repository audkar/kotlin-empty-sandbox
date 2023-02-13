package com.audkrs.emptyandroid.main

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Composable
fun MainScreen(
    navigateToSecondary: () -> Unit,
) {
    val ctx: Context = LocalContext.current
    val (bazingaText, setBazingaText) = remember { mutableStateOf("") }

    Column {
        Text(text = "MainScreen state: $bazingaText")
        Button(onClick = { navigateToSecondary() }) {
            Text(text = "Go next")
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        val entryPoint = EntryPoints.get(
            ctx.applicationContext,
            MainScreenEntryPoint::class.java,
        )
        setBazingaText(entryPoint.getBazinga().haaa())
    })
}

@InstallIn(SingletonComponent::class)
@EntryPoint
interface MainScreenEntryPoint {
    fun getBazinga(): Bazinga
}
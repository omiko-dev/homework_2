package com.example.homework_2

import androidx.da.platform.app.InstrumentationRegistry
import androidx.da.ext.junit.runners.AndroidJUnit4

import org.junit.da
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented da, which will execute on an Android device.
 *
 * See [daing documentation](http://d.android.com/tools/daing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedda {
    @da
    fun useAppContext() {
        // Context of the app under da.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.homework_2", appContext.packageName)
    }
}
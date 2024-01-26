package com.devhp.jetnews_app_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.devhp.jetnews_app_clone.JetnewsApplication

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val appContainer = (application as JetnewsApplication).container
        setContent {
            val withSizeClass = calculateWindowSizeClass(activity = this).widthSizeClass
            JetnewsApp(appContainer = appContainer, withSizeClass = withSizeClass)
        }

    }

}


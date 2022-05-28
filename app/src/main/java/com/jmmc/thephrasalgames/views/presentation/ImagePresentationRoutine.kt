package com.jmmc.thephrasalgames.views.presentation

import android.app.Activity
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmmc.thephrasalgames.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ImagePresentationRoutine(val activity: IRoutineCounter, val imageView: ImageView): ViewModel() {
    val TAG_CLASS="ImageModel"
    val DELAY_IMAGE=100L
    var lisImages= listOf(
        R.drawable.walk_1,
        R.drawable.walk_2,
        R.drawable.walk_3,
        R.drawable.walk_4,
        R.drawable.walk_5,
        R.drawable.walk_6,
        R.drawable.walk_7,
        R.drawable.walk_8,
        R.drawable.walk_9,
        R.drawable.walk_10
    )

    private fun printPicture(imageIndex:Int) {
        // Create a new coroutine to move the execution off the UI thread
        Log.d(TAG_CLASS,"//////////////////////////////////////// Data: ${imageIndex}")
        viewModelScope.launch(Dispatchers.Main) {
            (activity as Activity).runOnUiThread {
                imageView.setBackgroundResource(imageIndex)
            }
        }
    }

    fun playWords()= viewModelScope.launch(Dispatchers.IO)  {
        repeat(3) {
            lisImages.asFlow()
                .map { value ->
                    delay(DELAY_IMAGE)
                    value
                }
                .collect { value -> printPicture(value) }
        }
        activity.endRoutine()
        Log.d(TAG_CLASS,"//////////////////////////////////////// END CYCLE")
    }
}
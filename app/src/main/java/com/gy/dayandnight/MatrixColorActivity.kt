package com.gy.dayandnight

import android.app.Activity
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MatrixColorActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix_color)

    }

    fun tint(view:View) {
        val paint = Paint()
        val cm = ColorMatrix(
            floatArrayOf()
        )
        paint.colorFilter = ColorMatrixColorFilter(cm)
        view.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
    }

}
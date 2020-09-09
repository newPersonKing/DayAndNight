package com.gy.dayandnight

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_day_night.*


class DayAndNightActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_night)

        val paint = Paint()
        val cm = ColorMatrix()
        cm.setSaturation(0f)
        paint.colorFilter = ColorMatrixColorFilter(cm)
        iv_test.setLayerType(View.LAYER_TYPE_HARDWARE, paint)

        /*直接替换decorView 跟整体替换一个效果*/
//        val paint = Paint()
//        val cm = ColorMatrix()
//        cm.setSaturation(0f)
//        mPaint.setColorFilter(ColorMatrixColorFilter(cm))
//        window.decorView.setLayerType(View.LAYER_TYPE_HARDWARE, paint)

    }
}
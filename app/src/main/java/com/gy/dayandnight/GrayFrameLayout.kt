package com.gy.dayandnight

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class GrayFrameLayout @JvmOverloads constructor(context:Context,attrs : AttributeSet? = null,defaultStyle:Int = 0) : FrameLayout(context,attrs,defaultStyle){

    val paint = Paint()

    init {

        val colorMartix = ColorMatrix()
        colorMartix.setSaturation(0f)
        paint.colorFilter = ColorMatrixColorFilter(colorMartix)

    }

    override fun dispatchDraw(canvas: Canvas) {
        /*默认也是 Canvas.ALL_SAVE_FLAG*/
        canvas.saveLayer(null,paint)
        super.dispatchDraw(canvas)
        canvas.restore()
    }

    override fun onDraw(canvas: Canvas) {
        /*默认也是 Canvas.ALL_SAVE_FLAG*/
        canvas.saveLayer(null,paint)
        super.onDraw(canvas)
        canvas.restore()
    }

}
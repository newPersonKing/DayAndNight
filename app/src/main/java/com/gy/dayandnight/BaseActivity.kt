package com.gy.dayandnight

import android.R
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity :AppCompatActivity(){

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        val isNight = intent.getBooleanExtra("isNight", false)

        /*这种方案的问题是 部分特殊控件可能会异常*/
        if ("FrameLayout" == name && isNight) {
            val count = attrs.attributeCount
            for (i in 0 until count) {
                val attributeName = attrs.getAttributeName(i)
                val attributeValue = attrs.getAttributeValue(i)
                if (attributeName == "id") {
                    val id = attributeValue.substring(1).toInt()
                    val idVal = resources.getResourceName(id)
                    if ("android:id/content" == idVal) {
                        val grayFrameLayout = GrayFrameLayout(context, attrs)
                        val a = TypedValue()
                        theme.resolveAttribute(R.attr.windowBackground, a, true)
                        if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT) {
                            // windowBackground is a color
                            val color = a.data
                            grayFrameLayout.setBackgroundColor(Color.RED)
                        } else {
                            // windowBackground is not a color, probably a drawable
                            val c = resources.getDrawable(a.resourceId)
                            grayFrameLayout.background = c
                        }
                        return grayFrameLayout
                    }
                }
            }
        }

        return super.onCreateView(name, context, attrs)
    }
}
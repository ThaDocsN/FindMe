package com.example.android.myapplication

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.example.android.myapplication.R.*
import kotlin.properties.Delegates

class LoadingButton(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    private var textString = ""
    private var txtColor = 0
    private var btnBackground = 0

    private val valueAnimator = ValueAnimator()

    private var buttonState: ButtonState by Delegates.observable<ButtonState>(ButtonState.Completed) { p, old, new ->

    }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            styleable.LoadingButton,
            0,
            0
        ).apply {
            try {
                textString = getString(styleable.LoadingButton_txtString).toString()
                txtColor = getColor(styleable.LoadingButton_txtColor, Color.BLACK)
                btnBackground = getColor(styleable.LoadingButton_btnBackground, 0)
            }finally {
                recycle()
            }

        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = resolveSizeAndState(minw, widthMeasureSpec, 1)
        val h: Int = resolveSizeAndState(
            MeasureSpec.getSize(w),
            heightMeasureSpec,
            0
        )
        setMeasuredDimension(w, h)
    }
}
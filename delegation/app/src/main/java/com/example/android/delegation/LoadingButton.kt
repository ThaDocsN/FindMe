package com.example.android.delegation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColor
import com.example.android.delegation.R.styleable
import timber.log.Timber
import kotlin.properties.Delegates

class LoadingButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var btnTxtColor = 0
    private var btnColor    = 0
    private var widthSize   = 0
    private var heightSize  = 0

    private val valueAnimator = ValueAnimator()

    private var buttonState: ButtonState by Delegates.observable<ButtonState>(ButtonState.Completed) { p, old, new ->

    }

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {

        context.theme.obtainStyledAttributes(
                attrs,
                styleable.LoadingButton,
                0,
                0
        ).apply {
            try {
                btnColor = getColor(styleable.LoadingButton_btnBackground, Color.BLACK)
                Timber.i(btnColor.toString())
                btnTxtColor = getColor(styleable.LoadingButton_txtColor, 0)
            }finally {
                recycle()
            }

        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawButton(canvas)

    }

    private fun drawButton(canvas:Canvas){
        Timber.i("created")
        paint.color = btnColor
        Timber.i(paint.color.toString())
        paint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawRect(
            widthSize.toFloat(),
            heightSize.toFloat(),
            widthSize.toFloat(),
            heightSize.toFloat(),
            paint)
    }

    override fun performClick(): Boolean {
        Timber.i("Running")
        return super.performClick()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = resolveSizeAndState(minw, widthMeasureSpec, 1)
        val h: Int = resolveSizeAndState(
            MeasureSpec.getSize(w),
            heightMeasureSpec,
            0
        )
        widthSize = w
        heightSize = h
        setMeasuredDimension(w, h)
    }

}
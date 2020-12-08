package com.example.android.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import kotlin.math.min

class LoadButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    private lateinit var txtString: String
    private var radius        = 0.0f
    private var btnColor      = 0
    private var txtColor      = 0
    private var xSpacing      = 200.0
    private var ySpacing      = 15.0
    private val lilCircle     = true
    private var paint         = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        context.withStyledAttributes(
                attrs,
                R.styleable.LoadButton
        ){
            txtString = getString(R.styleable.LoadButton_txtShow).toString()
            txtColor  = getColor(R.styleable.LoadButton_txtColor, 0)
            btnColor  = getColor(R.styleable.LoadButton_btnBackground, 0)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = (min(w, h) / 2 * .6).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawButton(canvas)
        drawText(canvas)
        if (lilCircle){
        drawCircle(canvas)
        }
    }

    private fun drawCircle(canvas: Canvas) {
        paint.apply {
            color = Color.YELLOW
            style = Paint.Style.FILL
        }
        canvas.drawCircle((measuredWidth.toFloat() / 2 + xSpacing).toFloat(), (measuredHeight.toFloat() / 2 - ySpacing).toFloat(), radius, paint)
    }

    private fun drawText(canvas: Canvas) {
        paint.apply {
            color     = txtColor
            textAlign = Paint.Align.CENTER
            textSize  = 40.0F
        }
        canvas.drawText(txtString, measuredWidth.toFloat() / 2, measuredHeight.toFloat() / 2, paint)
    }

    private fun drawButton(canvas: Canvas) {
        paint.color = btnColor
        paint.style = Paint.Style.FILL
        canvas.drawColor(paint.color)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minW: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int    = resolveSizeAndState(minW, widthMeasureSpec, 1)
        val h: Int    = resolveSizeAndState(
                MeasureSpec.getSize(w),
                heightMeasureSpec,
                0
        )

        setMeasuredDimension(w, h)
    }
}
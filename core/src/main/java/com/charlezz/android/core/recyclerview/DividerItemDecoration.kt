package com.charlezz.android.core.recyclerview

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.IntDef
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * @author Charlezz
 */
class DividerItemDecoration : RecyclerView.ItemDecoration {
    @IntDef(value = [DIVIDER_VERTICAL, DIVIDER_HORIZONTAL, DIVIDER_GRID], flag = true)
    @Retention(RetentionPolicy.SOURCE)
    internal annotation class DividerType

    private var divider: Drawable?
    private var dividerType: Int
    private var dividerMarginPx = 0
    private var lastItemDividerVisible = true
    private var context: Context

    constructor(context: Context, @DividerType dividerType: Int) {
        divider = ColorDrawable(ContextCompat.getColor(context, R.color.darker_gray))
        this.dividerType = dividerType
        this.context = context
    }

    constructor(context: Context, @DividerType dividerType: Int, dividerResId: Int) {
        divider = ContextCompat.getDrawable(context, dividerResId)
        this.dividerType = dividerType
        this.context = context
    }

    constructor(context: Context, @DividerType dividerType: Int, dividerResId: Int, dividerMarginPx: Int, lastItemDividerVisible: Boolean) {
        divider = ContextCompat.getDrawable(context, dividerResId)
        this.dividerType = dividerType
        this.dividerMarginPx = dividerMarginPx
        this.lastItemDividerVisible = lastItemDividerVisible
        this.context = context
    }

    constructor(context: Context, @DividerType dividerType: Int, @ColorRes colorResId: Int, dividerMarginPx: Int, dividerHeightPx: Int, lastItemDividerVisible: Boolean) {
        divider = ColorDrawable(ContextCompat.getColor(context, colorResId))
        divider?.setBounds(0, 0, 0, dividerHeightPx)
        this.dividerType = dividerType
        this.dividerMarginPx = dividerMarginPx
        this.lastItemDividerVisible = lastItemDividerVisible
        this.context = context
    }

    fun setDividerMargin(margin: Float): DividerItemDecoration {
        this.dividerMarginPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margin, context.resources.displayMetrics).toInt()
        return this
    }

    fun setLastItemDividerVisible(visible: Boolean): DividerItemDecoration {
        lastItemDividerVisible = visible
        return this
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        when (dividerType) {
            DIVIDER_VERTICAL -> drawVertical(canvas, parent)
            DIVIDER_HORIZONTAL -> drawHorizontal(canvas, parent)
            DIVIDER_GRID -> {
                drawVertical(canvas, parent)
                drawHorizontal(canvas, parent)
            }
        }
    }

    fun drawHorizontal(canvas: Canvas?, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = if (lastItemDividerVisible) parent.childCount else parent.childCount - 1
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                    .layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight
            divider!!.setBounds(left + dividerMarginPx, top, right - dividerMarginPx, bottom)
            divider!!.draw(canvas!!)
        }
    }

    fun drawVertical(c: Canvas?, parent: RecyclerView) {
        val childCount = if (lastItemDividerVisible) parent.childCount else parent.childCount - 1
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                    .layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + divider!!.intrinsicHeight
            divider!!.setBounds(left, child.top, right, child.bottom)
            divider!!.draw(c!!)
        }
    }

    companion object {
        const val DIVIDER_VERTICAL = 0
        const val DIVIDER_HORIZONTAL = 1
        const val DIVIDER_GRID = 2
    }
}
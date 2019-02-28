package diat.diatapp.com.kotlin.adapter

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper


class SwipeToDeleteCallback : ItemTouchHelper.SimpleCallback {

    var adapter: TaskListAdapter

    var icon: Drawable? = null
    var background: ColorDrawable

    constructor(adapter: TaskListAdapter) : super(0, ItemTouchHelper.LEFT) {
        this.adapter = adapter

        //icon = ContextCompat.getDrawable(adapter.context,
                //android.R.drawable.ic_delete)
        background = ColorDrawable(Color.RED)
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        val position = viewHolder!!.adapterPosition
        adapter.deleteItem(position)
    }

    override fun onChildDraw(c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val itemView = viewHolder!!.itemView
        val backgroundCornerOffset = 0 //so background is behind the rounded corners of itemView

        var iconMargin = 0
        var iconTop = 0
        var iconBottom = 0

        if (icon != null) {
            iconMargin = (itemView.height - icon!!.intrinsicHeight) / 2
            iconTop = itemView.top + (itemView.height - icon!!.intrinsicHeight) / 2
            iconBottom = iconTop + icon!!.intrinsicHeight
        }

        var iconLeft = 0
        var iconRight = 0

        if (dX < 0) { // Swiping to the left
            if (icon != null) {
                iconLeft = itemView.right - iconMargin - icon!!.intrinsicWidth
                iconRight = itemView.right - iconMargin
            }

            icon?.setBounds(iconLeft, iconTop, iconRight, iconBottom)

            background.setBounds((itemView.right + dX - backgroundCornerOffset).toInt(),
                    itemView.top, itemView.right, itemView.bottom)
        } else { // view is unSwiped
            background.setBounds(0, 0, 0, 0)
        }

        background.draw(c)
        icon?.draw(c)
    }
}
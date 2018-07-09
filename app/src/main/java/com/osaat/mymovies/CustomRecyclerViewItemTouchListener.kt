package com.osaat.mymovies

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.annotations.NotNull

class CustomRecyclerViewItemTouchListener(
        recyclerView: RecyclerView,
        @IdRes specialIds: IntArray?,
        clickListener: MyCustomClickListener) :
BaseRecyclerViewItemTouchListener<CustomRecyclerViewItemTouchListener.MyCustomClickListener>(recyclerView, specialIds, clickListener) {

    companion object {
        private const val SPECIAL_VIEW_CLICK_AREA_EXTENSION = 5//this is gonna be converted to 5dp
    }

    private var clickPadding: Int

    init {
        clickPadding = (SPECIAL_VIEW_CLICK_AREA_EXTENSION * recyclerView.resources.displayMetrics.density).toInt()
    }

    interface MyCustomClickListener : BaseRecyclerViewItemTouchListener.ClickListener

    override fun onSpecialViewClick(@NotNull specialChildView: View,
                                    listPosition: Int) {
        clickListener.onClick(specialChildView, listPosition)

    }

    override fun getSpecialViewClickPadding(): Int = clickPadding

}
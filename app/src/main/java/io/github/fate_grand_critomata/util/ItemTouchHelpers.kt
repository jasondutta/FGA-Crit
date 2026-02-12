package io.github.fate_grand_critomata.util

interface IItemTouchHelperAdapter {
    fun onItemMove(From: Int, To: Int)
}

interface IItemTouchHelperViewHolder {
    fun onItemSelected()

    fun onItemClear()
}


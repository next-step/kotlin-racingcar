package com.nextstep.domain

class StringStore(string: String) {
    private val stores: List<String>
    private fun validation(stores: List<String>) {
        for (index in stores.indices) {
            checkValid(stores[index], index)
        }
    }

    private fun checkValid(store: String, index: Int) {
        if (isEven(store.length)) throw IllegalArgumentException("입력을 확인해주세요")

        if (isEven(index)) {
            store.toInt()
            return
        }
        Operator.valueOfOperator(store)
    }

    private fun isEven(index: Int): Boolean {
        return index % 2 == 0
    }

    companion object {
        const val SPACE = " "
    }

    init {
        val stores =
            listOf(*string.split(SPACE.toRegex()).toTypedArray())
        validation(stores)
        this.stores = stores
    }
}

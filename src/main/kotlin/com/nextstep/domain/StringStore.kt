package com.nextstep.domain

import java.util.LinkedList
import java.util.Queue

class StringStore(string: String) {
    private val stores: Queue<String>
    private fun validation(stores: List<String>) {
        if (isEven(stores.size)) throw IllegalArgumentException("입력을 확인해주세요")

        for (index in stores.indices) {
            checkValid(stores[index], index)
        }
    }

    fun calculate(): Int {
        var calculatedData = stores.poll().toInt()

        while (!stores.isEmpty()) {
            val operatorValue = stores.poll()
            val operator = Operator.valueOfOperator(operatorValue)
            val secondData = stores.poll().toInt()

            calculatedData = StringCalculator.calculate(operator, calculatedData, secondData)
        }

        return calculatedData
    }

    private fun checkValid(store: String, index: Int) {
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
        this.stores = LinkedList<String>(stores)
    }
}

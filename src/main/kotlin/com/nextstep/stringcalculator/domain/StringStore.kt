package com.nextstep.stringcalculator.domain

import java.util.LinkedList
import java.util.Queue

class StringStore(string: String) {
    private val stores: Queue<String>

    init {
        val stores =
            listOf(*string.split(SPACE.toRegex()).toTypedArray())
        checkStores(stores)
        this.stores = LinkedList<String>(stores)
    }

    private fun checkStores(stores: List<String>) {
        if (stores.size.isEven()) throw IllegalArgumentException("입력을 확인해주세요")

        for (index in stores.indices) {
            checkStore(stores[index], index)
        }
    }

    private fun checkStore(store: String, index: Int) {
        if (index.isEven()) {
            store.toInt()
            return
        }
        Operator.valueOfOperator(store)
    }

    private fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    fun calculate(): Double {
        var calculatedData = stores.poll().toDouble()

        while (!stores.isEmpty()) {
            val operatorValue = stores.poll()
            val operator = Operator.valueOfOperator(operatorValue)
            val secondData = stores.poll().toDouble()

            calculatedData = StringCalculator.calculate(operator, calculatedData, secondData)
        }

        return calculatedData
    }

    companion object {
        const val SPACE = " "
    }
}

package calculator

import common.Constant.SPACING

object StringCalculator {

    private const val FOREACH_STEP_NUMBER = 2
    private const val FOREACH_START_NUMBER = 1
    private const val ADD_NUMBER = 1
    private const val COLLECTION_FIRST_NUMBER = 0

    fun calculation(inputValue: String): Int {
        val operatorAndNumberList = CalculatorInputValue(inputValue).value.split(SPACING)
        var operatorResult = operatorAndNumberList[COLLECTION_FIRST_NUMBER].valueToInt()
        for (i in FOREACH_START_NUMBER until operatorAndNumberList.count() step (FOREACH_STEP_NUMBER)) {
            val operator = operatorAndNumberList[i]
            val secondaryNumberIndex = i + ADD_NUMBER
            operatorResult = FourArithmetic.confirmFourArithmetic(operator,
                OperationNumbers(operatorResult, operatorAndNumberList[secondaryNumberIndex].valueToInt()))
        }
        return operatorResult
    }

    private fun String.valueToInt(): Int {
        return this.toInt()
    }
}


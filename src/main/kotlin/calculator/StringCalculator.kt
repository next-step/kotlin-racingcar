package calculator

import common.Constant.SPACING

object StringCalculator {

    private const val FOREACH_STEP_NUMBER: Int = 2
    private const val FOREACH_START_NUMBER = 1
    private const val ADD_NUMBER = 1
    private const val COLLECTION_FIRST_NUMBER = 0

    fun calculation(inputValue: String): Int {
        val operatorAndNumberList = CalculatorInputValue(inputValue).value.split(SPACING)

        var operatorResult = valueToInt(operatorAndNumberList[COLLECTION_FIRST_NUMBER])
        for (i in FOREACH_START_NUMBER until operatorAndNumberList.count() step (FOREACH_STEP_NUMBER)) {
            val operator = operatorAndNumberList[i]
            operatorResult = FourArithmetic.confirmFourArithmetic(operator,
                OperationNumbers(operatorResult, valueToInt(operatorAndNumberList[i + ADD_NUMBER])))
        }

        return operatorResult
    }

    private fun valueToInt(inputValue: String) = inputValue.toInt()
}

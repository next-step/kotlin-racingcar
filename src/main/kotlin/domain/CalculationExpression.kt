package domain

import constant.Constants.Companion.OPERATOR
import java.lang.IllegalArgumentException

class CalculationExpression(inputData: String?) {
    val operand: Operand
    val operator: Operator
    private val operandList = ArrayList<String?>()
    private val operatorList = ArrayList<String?>()

    init {
        val splitInput = splitInputData(inputData)

        if (ValidationChecker().isOperator(splitInput[0])) {
            throw IllegalArgumentException()
        }

        for (i in 0 until splitInputData(inputData).size) {
            if (isOperator(i)) {
                operatorList.add(splitInput[i])
                continue
            }
            operandList.add(splitInput[i])
        }

        operand = Operand(operandList)
        operator = Operator(operatorList)
    }

    private fun splitInputData(inputData: String?): List<String> {
        return inputData?.split(" ")!!
    }

    private fun isOperator(i: Int): Boolean {
        return i % 2 == OPERATOR
    }
}

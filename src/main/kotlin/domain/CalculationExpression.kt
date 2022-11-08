package domain

import java.lang.IllegalArgumentException

const val OPERATOR = 1
class CalculationExpression(inputData: String?) {
    val operand: Operand
    val operator: Operator
    private val operandList = ArrayList<Double>()
    private val operatorList = ArrayList<String?>()
    private val splitInput: List<String>
    init {
        splitInput = splitInputData(inputData)

        if (ValidationChecker().isOperator(splitInput[0])) {
            throw IllegalArgumentException()
        }

        for (i in 0 until splitInputData(inputData).size) {
            createSplitInputList(i)
        }

        operand = Operand(operandList)
        operator = Operator(operatorList)
    }

    private fun splitInputData(inputData: String?): List<String> {
        return inputData?.split(" ")!!
    }

    private fun createSplitInputList(index: Int) {
        if (isOperator(index)) {
            operatorList.add(splitInput[index])
            return
        }
        operandList.add(splitInput[index].toDouble())
    }

    private fun isOperator(i: Int): Boolean {
        return i % 2 == OPERATOR
    }
}

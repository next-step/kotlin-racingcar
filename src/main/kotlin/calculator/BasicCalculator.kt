package calculator

import java.lang.IllegalArgumentException

class BasicCalculator : Calculator {
    private var currentOperationSymbol = OperationSymbol.ADD
    private var result = 0
    override fun calculate(operation: String?): Int {
        validateOperation(operation)
        initCalculator()

        splitOperation(operation)
            .forEach { op ->
                if (isNumeric(op)) {
                    result = currentOperationSymbol.execute(result, op.toInt())
                    return@forEach
                }
                currentOperationSymbol = OperationSymbol.bySymbol(op)
            }

        return result
    }

    private fun splitOperation(operation: String?) = operation!!.split(" ")

    private fun initCalculator() {
        currentOperationSymbol = OperationSymbol.ADD
        result = 0
    }

    private fun isNumeric(op: String) = op.toIntOrNull() != null

    private fun validateOperation(operation: String?) {
        if (operation.isNullOrEmpty()) throw IllegalArgumentException("Operation is null or empty")
    }
}

package calculator

import java.lang.IllegalArgumentException

class BasicCalculator : Calculator {
    private var currOperationSymbol = OperationSymbol.ADD
    private var result = 0
    override fun calculate(operation: String?): Int {
        validateOperation(operation)
        initCalculator()

        operation!!.split(" ")
            .forEach { op ->
                if (isNumeric(op)) {
                    result = currOperationSymbol.execute(result, op.toInt())
                    return@forEach
                }
                currOperationSymbol = OperationSymbol.bySymbol(op)
            }

        return result
    }

    private fun initCalculator() {
        currOperationSymbol = OperationSymbol.ADD
        result = 0
    }

    private fun isNumeric(op: String) = op.toIntOrNull() != null

    private fun validateOperation(operation: String?) {
        if (operation.isNullOrEmpty()) throw IllegalArgumentException("Operation is null or empty")
    }
}

package stringCalculator

class StringOperator(
    private var firstOperand: String? = null,
    private var secondOperand: String? = null,
    private var operator: String? = null,
    private var operateResult: Int = 0
) {
    private fun operate(): Int {
        if (firstOperand != null && secondOperand != null && operator != null) {
            operateResult = Operation.operation(firstOperand!!, secondOperand!!, operator!!)
            firstOperand = operateResult.toString()
            secondOperand = null
            operator = null
        }

        return operateResult
    }

    fun numberProcess(str: String) {
        if (firstOperand == null)
            firstOperand = str

        if (operator != null && secondOperand == null)
            secondOperand = str

        operate()
    }

    fun operatorProcess(str: String) {
        operator = str
    }

    fun getResult(): Int {
        return operateResult
    }
}

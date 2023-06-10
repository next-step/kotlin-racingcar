class StringOperator(
    private var firstOperand: String = "",
    private var secondOperand: String = "",
    private var operator: Char? = null,
    private var operateResult: Int = 0
) {
    fun operate(): Int {
        if (firstOperand.isNotBlank() &&
            secondOperand.isNotBlank() &&
            operator != null
        ) {
            operateResult = Operation.operation(firstOperand, secondOperand, operator!!)
            firstOperand = operateResult.toString()
            secondOperand = ""
            operator = null
        }

        return operateResult
    }

    fun numberProcess(c: Char) {
        if (operator == null)
            firstOperand += c

        if (firstOperand != "" && operator != null)
            secondOperand += c
    }

    fun blankProcess() {
        operate()
    }

    fun operatorProcess(c: Char) {
        operator = c
    }

    fun getResult(): Int {
        operate()
        return operateResult
    }
}

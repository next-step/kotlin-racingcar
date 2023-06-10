class StringCalculatorScanner(
    var firstOperand: String = "",
    var secondOperand: String = "",
    var operator: Char? = null,
    private var operateResult: Int = 0
) {

    fun scan(input: String) {
        input.forEach { c ->
            val charTypeProcessStrategy: CharTypeProcessStrategy =
                when (CharParser.parseChar(c)) {
                    CharType.NUMBER -> NumberCharTypeProcessStrategy()
                    CharType.BLANK -> BlankCharTypeProcessStrategy()
                    CharType.OPERATOR -> OperatorCharTypeProcessStrategy()
                }

            charTypeProcessStrategy.execute(this, c)
        }
    }

    fun operate(): Int {
        if (firstOperand != "" && secondOperand != "") {
            operateResult = Operation.operation(firstOperand, secondOperand, operator!!)
            firstOperand = operateResult.toString()
            secondOperand = ""
            operator = null
        }

        return operateResult
    }
}

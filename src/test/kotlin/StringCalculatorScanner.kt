class StringCalculatorScanner(
    private var firstOperand: String = "",
    private var secondOperand: String = "",
    private var operator: Char? = null,
    private var operateResult: Int = 0
) {

    fun scan(c: Char) {
        when (CharParser.parseChar(c)) {
            CharType.NUMBER -> {
                if (operator == null)
                    firstOperand += c

                if (firstOperand != "" && operator != null)
                    secondOperand += c
            }

            CharType.BLANK -> {
                operate()
            }

            CharType.OPERATOR -> {
                operator = c
            }
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

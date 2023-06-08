class StringCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty())
            throw IllegalArgumentException("문자열을 확인해 주세요")

        var firstOperand: String = ""
        var secondOperand: String = ""
        var operator: Char? = null
        var operateResult: Int = 0

        input.forEach { c ->
            when (CharParser.parseChar(c)) {
                CharType.NUMBER -> {
                    if (operator == null)
                        firstOperand += c

                    if (firstOperand != "" && operator != null)
                        secondOperand += c
                }

                CharType.BLANK -> {
                    if (firstOperand != "" && secondOperand != "") {
                        operateResult = Operation.operation(firstOperand, secondOperand, operator!!)
                        firstOperand = operateResult.toString()
                        secondOperand = ""
                        operator = null
                    }
                }

                CharType.OPERATOR -> {
                    operator = c
                }
            }
        }

        // 마지막 원소 계산
        return Operation.operation(firstOperand, secondOperand, operator!!)
    }
}

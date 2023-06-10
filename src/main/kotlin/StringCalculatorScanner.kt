class StringCalculatorScanner {
    fun scan(input: String): Int {
        val stringOperator = StringOperator()

        input.forEach { c ->
            when (CharParser.parseChar(c)) {
                CharType.NUMBER -> stringOperator.numberProcess(c)
                CharType.BLANK -> stringOperator.blankProcess()
                CharType.OPERATOR -> stringOperator.operatorProcess(c)
            }
        }

        return stringOperator.getResult()
    }
}

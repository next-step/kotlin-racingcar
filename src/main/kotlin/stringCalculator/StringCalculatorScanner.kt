package stringCalculator

class StringCalculatorScanner {
    fun scan(input: List<String>): Int {
        val stringOperator = StringOperator()

        input.forEach { str ->
            when (StringParser.parseString(str)) {
                StringType.NUMBER -> stringOperator.numberProcess(str)
                StringType.OPERATOR -> stringOperator.operatorProcess(str)
            }
        }

        return stringOperator.getResult()
    }
}

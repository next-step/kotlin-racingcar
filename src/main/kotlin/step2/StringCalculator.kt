package step2

class StringCalculator {

    companion object {
        private const val INDEX_OF_OPERATOR = 0
        private const val INDEX_OF_OPERAND = 1

        fun calculate(splitValues: List<String>): Operand {
            var result = Operand(splitValues[0].toDouble())
            for (i in 1 until splitValues.size step 2) {
                val operator = Operator.findBySymbol(splitValues[INDEX_OF_OPERATOR + i])
                val operand = Operand(splitValues[INDEX_OF_OPERAND + i].toDouble())
                result = operator.calculate(result, operand)
            }
            return result
        }
    }
}

package study.stringCalculator

class StringCalculator {

    fun calculate(mathExpression: String): Int {
        val numbersAndOperators = mathExpression.checkEmptyOrNull().split(" ")
        val numbers = numbersAndOperators.filterIndexed { index, _ -> index % 2 == 0 }.map { it.toInt() }
        val operators = numbersAndOperators.filterIndexed { index, _ -> index % 2 != 0 }.toList()

        val numbersToOperate = numbers.drop(1)
        val pairs = operators.zip(numbersToOperate).map { (operator, number) -> Pair(operator, number) }

        return calculateEveryPair(pairs, numbers[0])
    }

    private fun String.checkEmptyOrNull(): String {
        require(!this.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자일 경우" }
        return this
    }

    private fun calculateEveryPair(pairs: List<Pair<String, Int>>, initValue: Int): Int {
        return pairs.fold(initValue) { acc, (operator, number) ->
            val enumOperator = Operator.reverseMap(operator) ?: throw IllegalArgumentException("사칙연산 기호가 아닙니다“")
            enumOperator.work(acc, number)
        }
    }
}
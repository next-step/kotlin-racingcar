package study

class StringCalculator {

    fun calculate(mathExpression: String): Int {
        val stringList = mathExpression.checkEmptyOrNull().split(" ")
        val numberList = stringList.filterIndexed { index, _ -> index % 2 == 0 }.map { it.toInt() }
        val operatorList = stringList.filterIndexed { index, _ -> index % 2 != 0 }.toList().checkMathSymbol()

        val numberListToOperate = numberList.drop(1)
        val pairList = operatorList.zip(numberListToOperate).map { (operator, number) -> Pair(operator, number) }

        val initialValue = numberList.component1()

        return calculateEveryPair(pairList, initialValue)
    }

    private fun String.checkEmptyOrNull(): String {
        require(!this.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자일 경우" }
        return this
    }

    private fun List<String>.checkMathSymbol(): List<String> {
        require(this.all { it in listOf("+", "-", "*", "/") }) { "사칙연산 기호가 아닌 경우" }
        return this
    }

    private fun calculateEveryPair(pairList: List<Pair<String, Int>>, initValue: Int): Int {
        return pairList.fold(initValue) { acc, pair ->
            when (pair.first) {
                Operator.ADD.symbol -> acc + pair.second
                Operator.SUBTRACT.symbol -> acc - pair.second
                Operator.MULTIPLY.symbol -> acc * pair.second
                Operator.DIVIDE.symbol -> acc / pair.second
                else -> throw IllegalArgumentException()
            }
        }
    }
}

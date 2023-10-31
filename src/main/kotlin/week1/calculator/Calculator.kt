package week1.calculator

object Calculator {

    private const val DELIMITER = ' '

    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank()) { "입력 값은 null 또는 빈 문자열을 허용하지 않습니다. - expression: [$expression]" }

        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<Operator>()
        expression.split(DELIMITER).forEach { chunk ->
            if (Operator.isOperatorSymbol(chunk)) {
                operators.add(Operator.from(chunk))
            } else {
                numbers.add(chunk.toInt())
            }
        }

        var result = numbers.first()

        operators.forEachIndexed { idx, operator ->
            val a = result
            val b = numbers[idx + 1]

            result = operator.execute(a, b)
        }
        return result
    }
}
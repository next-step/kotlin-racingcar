import java.lang.ArithmeticException

enum class Operator(val sign: String, val calculate: (num1: Int, num2: Int) -> Int) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE(
        "/",
        { num1, num2 ->
            if (num2 == 0) throw ArithmeticException("0으로 나눌 수 없습니다.")
            num1 / num2
        }
    );

    companion object {
        fun findBySign(currentSign: String): Operator =
            values().find { operator -> operator.sign == currentSign }
                ?: throw throw IllegalArgumentException("올바르지 않은 연산자 ${currentSign}이(가) 있습니다.")
    }
}

private const val REMAINDER_ZERO = 0
private const val REMAINDER_ONE = 1

class StringCalculator {

    companion object {
        private var result: Int = 0
    }

    fun calculate(expression: String?): Int {
        isCorrectFormat(expression)

        val expressionSplit = expression!!.trim().split(" ")

        val numbers = ArrayList<Int>()
        val operators = ArrayList<String>()

        separateNumsAndOperators(expressionSplit, numbers, operators)

        calculateInOrder(operators, numbers)

        return result
    }

    private fun isCorrectFormat(expression: String?) {
        if (expression.isNullOrEmpty() or (expression == " ")) throw IllegalArgumentException("값을 입력해주세요.")
    }

    // TODO 람다식 사용해보기? (람다식을 인자로 list의 원소를 filtering해보기)
    private fun separateNumsAndOperators(
        expressionSplit: List<String>,
        numbers: ArrayList<Int>,
        operators: ArrayList<String>
    ) {
        for (i in expressionSplit.indices) {
            if (i % 2 == REMAINDER_ZERO) numbers.add(expressionSplit[i].toInt())
            if (i % 2 == REMAINDER_ONE) operators.add(expressionSplit[i])
        }
    }

    private fun calculateInOrder(operators: ArrayList<String>, numbers: ArrayList<Int>) {
        result = numbers.removeAt(0)
        if (numbers.isEmpty()) return

        for (i in operators.indices) {
            val currentSign = operators.removeAt(0)
            result = Operator.findBySign(currentSign).calculate(result, numbers.removeAt(0))
        }
    }
}

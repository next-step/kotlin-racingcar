package calculator

enum class Operator(val remark: String, val compute: (Int, Int) -> Int) {
    PLUS("+", fun(number1: Int, number2: Int) = number1 + number2),
    MINUS("-", fun(number1: Int, number2: Int) = number1 - number2),
    MULTIPLIED("*", fun(number1: Int, number2: Int) = number1 * number2),
    DIVIDED("/", fun(number1: Int, number2: Int) = number1 / number2);

    companion object {
        fun findBy(remark: String): Operator = values()
            .find { operator -> operator.remark == remark }
            ?: throw IllegalArgumentException("알맞은 연산자가 없습니다: $remark")

        val isOrderOf: (Int) -> Boolean = fun(order: Int): Boolean { return order % 2 != 0 }
        val convertToOperator: (String) -> Operator = fun(input: String): Operator { return findBy(input) }
    }
}

package calculator

enum class Operator(val remark: String, val compute: (Operand, Operand) -> Operand) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLIED("*", { left, right -> left * right }),
    DIVIDED("/", { left, right -> left / right });

    companion object {
        fun getBy(remark: String): Operator = values()
            .find { operator -> operator.remark == remark }
            ?: throw IllegalArgumentException("알맞은 연산자가 없습니다: $remark")

        val isOrderOf: (Int) -> Boolean = fun(order: Int): Boolean { return order % 2 != 0 }
        val convertToOperator: (String) -> Operator = fun(input: String): Operator { return getBy(input) }
    }
}

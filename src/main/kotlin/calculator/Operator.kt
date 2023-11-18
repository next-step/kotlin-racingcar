package calculator

enum class Operator(
    val operator: String,
    val calculate: (Operand, Operand) -> Operand
) {
    PLUS("+", { first, second ->
        first.plus(second)
    }),

    MINUS("-", { first, second ->
        first.minus(second)
    }),

    TIMES("*", { first, second ->
        first.times(second)
    }),

    DIV("/", { first, second ->
        runCatching {
            first.div(second)
        }.getOrElse {
            println(it)
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
    });
}

class OperatorFinder {
    companion object {
        fun findOperator(input: String): Operator = Operator.entries.find { operator: Operator ->
            operator.operator == input
        } ?: throw IllegalArgumentException("잘못된 연산자 입니다.")
    }
}

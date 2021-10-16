package step2

enum class Operator(val op: String, val calculate: (first: Int, second: Int) -> Int) {
    PLUS("+", { first, second ->
        first + second
    }),
    MINUS("-", { first, second ->
        first - second
    }),
    MULTIPLE("*", { first, second ->
        first * second
    }),
    DIVISION("/", { first, second ->
        require(second != 0) { "0으로 나눌 수 없습니다." }
        first / second
    });

    companion object {
        fun convertToOperator(op: String): Operator {
            return requireNotNull(values().firstOrNull { it.op == op }) { "사칙연산 기호가 아닙니다." }
        }
    }
}

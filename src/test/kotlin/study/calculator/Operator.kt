package study.calculator

enum class Operator(val operator: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    DIVISION("/", { a, b -> a / b }),
    MULTIPLICATION("*", { a, b -> a * b });

    companion object {
        fun from(operator: String): Operator {
            return values().find { it.operator == operator }
                ?: throw IllegalArgumentException("알 수 없는 연산자 입니다. $operator")
        }
    }
}
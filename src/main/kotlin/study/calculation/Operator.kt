package study.calculation

enum class Operator(val oper: String, val calculation: (Int, Int) -> Int) {
    ADDITON("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b });

    companion object {
        fun select(oper: String): Operator {
            return values().find { it.oper == oper } ?: throw IllegalArgumentException("지원하는 연사자가 아닙니다.")
        }

        fun isOperator(oper: String): Boolean = values().any{ it.oper == oper }
    }
}

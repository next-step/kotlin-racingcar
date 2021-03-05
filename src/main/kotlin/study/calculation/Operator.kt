package study.calculation

enum class Operator(val oper: String, val calculation: (Int, Int) -> Int) {
    ADDITON("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b });

    companion object {
        fun select(oper: String): Operator {
            require(isOperator(oper)) {
                "지원하지 않는 연산자입니다."
            }

            return find(oper)!!
        }

        fun isOperator(oper: String): Boolean = find(oper) != null

        fun find(oper: String): Operator? = values().find { oper == it.oper }
    }
}

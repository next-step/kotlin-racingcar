package calculator

enum class Operator(val op: String, val number: (number1: Long, number2: Long) -> Long) {
    PLUS("+", { n1, n2 -> n1.plus(n2) }),
    MINUS("-", { n1, n2 -> n1.minus(n2) }),
    DIVISION("/", { n1, n2 -> n1.div(n2) }),
    MULTIPLE("*", { n1, n2 -> n1.times(n2) });

    companion object {
        fun find(op: String) =
            Operator.values().find { it.op == op }
                ?: throw IllegalArgumentException("Invalid Operator")
    }
}

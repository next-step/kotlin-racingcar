class Operation {
    companion object {
        fun operation(x: String, y: String, o: String): Int {
            val operator = Operator.values().find { it.operator == o }
                ?: throw IllegalArgumentException("+ - * / 를 제외한 다른 연산자가 포함되어 있습니다.")

            return operator.result(x, y)
        }
    }
}

enum class Operator(val operator: String, val result: (String, String) -> Int) {
    PLUS(
        "+", { s1, s2 -> Integer.valueOf(s1) + Integer.valueOf(s2) },
    ),
    MINUS(
        "-", { s1, s2 -> Integer.valueOf(s1) - Integer.valueOf(s2) },
    ),
    MULTIPLY(
        "*", { s1, s2 -> Integer.valueOf(s1) * Integer.valueOf(s2) },
    ),
    DIVISION(
        "/", { s1, s2 -> Integer.valueOf(s1) / Integer.valueOf(s2) },
    ),
}

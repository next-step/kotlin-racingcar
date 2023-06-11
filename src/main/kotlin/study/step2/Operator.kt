package study.step2

enum class Operator(val code: String, val operation: (Long, Long) -> Long) {
    SUM("+", { x, y -> x + y }),
    SUBTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVISION("/", { x, y -> x / y })
    ;

    companion object {
        fun ofCode(code: String) =
            values().find { it.code == code }
    }
}

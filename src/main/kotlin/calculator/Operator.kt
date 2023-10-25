package calculator

enum class Operator(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun of(operator: String): Operator {
            return values().find { it.operator == operator } ?: throw IllegalArgumentException("연산자가 아닙니다.")
        }
    }
}

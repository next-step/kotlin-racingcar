package calculator

enum class Operator {
    PLUS,
    MINUS,
    DIVIDE,
    MULTIPLY;
}
fun String.convertToOperatorEnum(): Operator =
    when (this) {
        "+" -> Operator.PLUS
        "-" -> Operator.MINUS
        "/" -> Operator.DIVIDE
        "*" -> Operator.MULTIPLY
        else -> throw java.lang.IllegalArgumentException("잘못된 연산자가 입력되었습니다.")
    }

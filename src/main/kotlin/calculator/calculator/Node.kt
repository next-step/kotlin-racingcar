package calculator.calculator

/**
 * 노드는 피연산자 Number와 연산자 Operator로 구성 되어 있다.
 */
interface Node

/**
 * Number는 피연산자로 값을 가지고 있다.
 */
data class Number(val value: Double) : Node

private const val PLUS_CHAR = "+"
private const val MINUS_CHAR = "-"
private const val MULTIPLY_CHAR = "*"
private const val DIVIDE_CHAR = "/"

enum class Operator(val char: String, val operate: (Number, Number) -> Number) : Node {
    PLUS(PLUS_CHAR, { left, right -> Number(left.value + right.value) }),
    MINUS(MINUS_CHAR, { left, right -> Number(left.value - right.value) }),
    MULTIPLY(MULTIPLY_CHAR, { left, right -> Number(left.value * right.value) }),
    DIVIDE(
        DIVIDE_CHAR,
        { left, right ->
            if (right.value != 0.0) {
                Number(left.value / right.value)
            } else {
                throw DivideByZeroException()
            }
        }
    );

    class DivideByZeroException : Exception("Cannot divide by 0.")
}

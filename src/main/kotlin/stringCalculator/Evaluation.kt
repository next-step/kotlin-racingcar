package stringCalculator

import stringCalculator.Message.Companion.INVALID_OPERATOR

enum class Evaluation(val operator: String, val applyOperator: (a: Int, b: Int) -> Int) {
    ADD(
        "+",
        { a: Int, b: Int -> a + b }
    ),
    SUBSTRATE(
        "-",
        { a: Int, b: Int -> a - b }
    ),
    MULTIPLE(
        "*",
        { a: Int, b: Int -> a * b }
    ),
    DIVIDE(
        "/",
        { a: Int, b: Int -> a / b }
    );

    companion object {
        fun find(operator: String): Evaluation {
            return Evaluation.values().find { it.operator == operator } ?: throw IllegalArgumentException(
                INVALID_OPERATOR
            )
        }
    }
}
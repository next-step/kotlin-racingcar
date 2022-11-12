package calculator.domain

enum class CalculatorType(val mathematicalExpression: (Double, Double) -> Double) {
    ADDITION({ a, b -> kotlin.math.round((a + b) * Calculator.ROUND) / Calculator.ROUND }),
    SUBTRACT({ a, b -> kotlin.math.round((a - b) * Calculator.ROUND) / Calculator.ROUND }),
    DIVISION({ a, b ->
        if (b == 0.0) {
            throw IllegalArgumentException()
        }
        kotlin.math.round((a / b) * Calculator.ROUND) / Calculator.ROUND
    }),
    MULTIPLICATION({ a, b -> kotlin.math.round((a * b) * Calculator.ROUND) / Calculator.ROUND });
}

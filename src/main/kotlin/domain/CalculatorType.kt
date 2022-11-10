package domain

enum class CalculatorType(val mathematicalExpression: (Double, Double) -> Double) {
    ADDITION({ a, b -> kotlin.math.round((a + b) * domain.Calculator.Companion.ROUND) / domain.Calculator.Companion.ROUND }),
    SUBTRACT({ a, b -> kotlin.math.round((a - b) * domain.Calculator.Companion.ROUND) / domain.Calculator.Companion.ROUND }),
    DIVISION({ a, b ->
        if (b == 0.0) {
            throw IllegalArgumentException()
        }
        kotlin.math.round((a / b) * domain.Calculator.Companion.ROUND) / domain.Calculator.Companion.ROUND
    }),
    MULTIPLICATION({ a, b -> kotlin.math.round((a * b) * domain.Calculator.Companion.ROUND) / domain.Calculator.Companion.ROUND });
}

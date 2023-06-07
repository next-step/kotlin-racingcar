package study.step2

class Calculator {
    companion object {
        private val operations = mapOf(
            "+" to { a: Double, b: Double -> a + b },
            "-" to { a: Double, b: Double -> a - b },
            "*" to { a: Double, b: Double -> a * b },
            "/" to { a: Double, b: Double -> a / b }
        )

        fun calculate(input: String?): Double {
            val formula = Formula(input)
            val expression = formula.expression
            var result = expression[0].toDouble()

            expression.drop(1).windowed(2, 2).forEach { (operation, number) ->
                val operation = operations[operation]
                    ?: throw IllegalArgumentException("유효하지 않은 연산자입니다.")
                result = operation(result, number.toDouble())
            }

            return result
        }
    }
}

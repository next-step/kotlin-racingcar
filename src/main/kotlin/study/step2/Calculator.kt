package study.step2

class Calculator {
    companion object {
        private val operations = mapOf(
            "+" to { a: Double, b: Double -> a + b },
            "-" to { a: Double, b: Double -> a - b },
            "*" to { a: Double, b: Double -> a * b },
            "/" to { a: Double, b: Double -> a / b }
        )
        fun calculate(formula: Formula): Double {
            val expression = formula.expression
            var result = expression[0].toDouble()

            for (i in 1 until expression.size step 2) {
                val operation = operations[expression[i]]
                    ?: throw IllegalArgumentException("유효하지 않은 연산자입니다.")
                result = operation(result, expression[i + 1].toDouble())
            }
            return result
        }
    }
}

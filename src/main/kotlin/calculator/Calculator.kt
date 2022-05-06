package calculator

object Calculator {

    fun calculate(string: String): Float {
        val equation = parseEquation(string)

        var result = equation.first().toFloat()

        equation
            .drop(1)
            .windowed(2, 2) { (a, b) ->
                val expression = Expression.from(a) ?: throw IllegalArgumentException()
                val number = b.toFloatOrNull() ?: throw IllegalArgumentException()
                result = expression.calculate(result, number)
            }

        return result
    }

    private fun parseEquation(string: String): List<String> {
        return string
            .replace(" ", "")
            .replace(Regex("([+\\-*/])")) { " ${it.value} " }
            .split(" ")
    }
}

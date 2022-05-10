package calculator

class Calculator {
    fun plus(a: Long, b: Long) = a + b
    fun minus(a: Long, b: Long) = a - b
    fun multiply(a: Long, b: Long) = a * b
    fun divide(a: Long, b: Long) = a / b

    fun calculate(formula: String?): Long {
        if (formula.isNullOrBlank())
            throw IllegalArgumentException()

        val iter = formula.split(" ").iterator()
            .takeIf { it.hasNext() }
            ?: throw IllegalArgumentException()

        var left = iter.nextLong()

        while (iter.hasNext()) {
            val operator = iter.nextOperator()
            val right = iter.nextLong()

            left = when (operator) {
                '+' -> plus(left, right)
                '-' -> minus(left, right)
                '*' -> multiply(left, right)
                '/' -> divide(left, right)
                else -> throw IllegalArgumentException()
            }
        }

        return left
    }

    private fun Iterator<String>.nextLong() = runCatching {
        next().toLong()
    }.getOrElse { throw IllegalArgumentException() }

    private fun Iterator<String>.nextOperator() = runCatching {
        next()[0]
    }.getOrElse { throw IllegalArgumentException() }
}

fun main() {
    println(Calculator().calculate("2 + 3 / 5"))
}

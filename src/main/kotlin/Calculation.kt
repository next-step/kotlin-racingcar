class Calculation {

    fun calcutateByString(input: String?): Int {
        if(input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        val splitedInput = input.split(" ")
        var result: Int = splitedInput.first().toInt()
        splitedInput.drop(1).windowed(2, 2).forEach {
            result = calculate(result, it[1].toInt(), it[0])
        }
        return result
    }

    private fun calculate(first: Int, second: Int, operator: String): Int {
        return when(operator) {
            "+" -> add(first, second)
            "-" -> subtract(first, second)
            "*" -> multiply(first, second)
            "/" -> divide(first, second)
            else -> throw IllegalArgumentException("Using unsupported operators")
        }
    }

    private fun add(first: Int, second: Int): Int {
        return first + second
    }

    private fun subtract(first: Int, second: Int): Int {
        return first - second
    }

    private fun multiply(first: Int, second: Int): Int {
        return first * second
    }

    private fun divide(first: Int, second: Int): Int {
        return first / second
    }
}
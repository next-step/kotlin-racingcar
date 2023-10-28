class StringCalculator(private val calculatorString: String?) {

    init {
        require(!calculatorString.isNullOrBlank()) { throw IllegalArgumentException() }
    }

    private val numberArgs by lazy {
        calculatorString?.split(" ")?.filter { it.isNotBlank() }?.filter { it.toIntOrNull() != null }?.map { it.toInt() }
    }
    private val operatorArgs by lazy {
        calculatorString?.split(" ")?.filter { it.isNotBlank() }?.filter { it.toIntOrNull() == null }?.toMutableList()
    }

    fun calculating(): Int? = numberArgs?.reduce { acc, next ->
        when (operatorArgs?.removeFirst()) {
            "+" -> plus(acc, next)
            "-" -> minus(acc, next)
            "*" -> multiple(acc, next)
            "/" -> divide(acc, next)
            else -> throw IllegalArgumentException()
        }
    }

    private fun plus(first: Int, second: Int): Int = first + second
    private fun minus(first: Int, second: Int): Int = first - second
    private fun multiple(first: Int, second: Int): Int = first * second
    private fun divide(first: Int, second: Int): Int = first / second
}

fun main() {

    StringCalculator("2 + 3 * 4 / 2").apply {
        println("result = ${calculating()}")
    }
}

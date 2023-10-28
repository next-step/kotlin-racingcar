class StringCalculator(private val calculatorString: String?) {

    private val tokens = calculatorString?.split(" ")?.filter { it.isNotBlank() } ?: emptyList()
    private val numberArgs: List<Int>
    private val operatorArgs: MutableList<String>

    init {
        require(!calculatorString.isNullOrBlank()) { throw IllegalArgumentException() }
        numberArgs = tokens.filter { it.toIntOrNull() != null }.map { it.toInt() }
        operatorArgs = tokens.filter { it.toIntOrNull() == null }.toMutableList()
        check(numberArgs.size > operatorArgs.size) { throw IllegalArgumentException() }
    }

    fun calculating(): Int = numberArgs.reduce { acc, next ->
        when (operatorArgs.removeFirst()) {
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

class StringCalculator(private val calculatorString: String?) {

    private val tokens = calculatorString?.split(" ")?.filter { it.isNotBlank() } ?: emptyList()
    private val numberArgs: List<Int>
    private val operatorArgs: List<String>

    init {
        require(!calculatorString.isNullOrBlank()) { throw IllegalArgumentException() }
        numberArgs = tokens.filter { it.toIntOrNull() != null }.map { it.toInt() }
        operatorArgs = tokens.filter { it.toIntOrNull() == null }
        check(numberArgs.size > operatorArgs.size) { throw IllegalArgumentException() }
    }

    fun calculating(operators: MutableList<String> = operatorArgs.toMutableList()): Int =
        numberArgs.reduce { acc, next ->
            when (operators.removeFirst()) {
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
    val test = StringCalculator("2 + 3 + 4 + 6")
    println("${test.calculating()}")
    println("${test.calculating()}")
    println("${test.calculating()}")
}

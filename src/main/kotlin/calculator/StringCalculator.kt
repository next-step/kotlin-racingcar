package calculator

class StringCalculator(private val input: Input) {

    fun calculate(): Number {
        val expression = Expression(input)
        return expression.calculate()
    }
}

fun main(args: Array<String>) {
    val input = Input(readlnOrNull())
    val calculator = StringCalculator(input)

    println(calculator.calculate())
}

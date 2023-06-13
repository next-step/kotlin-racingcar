package calculator

class StringCalculator(private val input: Input) {

    fun calculate(): Operand {
        val expression = Expression(input)
        return expression.calculate()
    }
}

fun main() {
    val input = Input(readlnOrNull())
    val calculator = StringCalculator(input)

    println(calculator.calculate())
}

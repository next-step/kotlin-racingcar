package calculator

import calculator.domain.Calculator
import calculator.io.Console
import calculator.utils.CalculatorParser

fun main() {
    Main().start()
}

class Main(
    private val calculator: Calculator,
    private val console: Console,
) {

    constructor() : this(
        Calculator(),
        Console(),
    )

    fun start() {
        val input = console.getInput()
        val extractedList = CalculatorParser.extract(input)
        val result = calculator.calculate(extractedList)
        println(result)
    }
}

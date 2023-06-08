package calculator

import calculator.domain.Calculator
import calculator.io.Console

fun main() {
    Main().start()
}

class Main(
    private val console: Console,
    private val calculator: Calculator
) {

    constructor() : this(
        Console(),
        Calculator()
    )

    fun start() {
        val input = console.getInput()
        calculator.run(input)
    }
}

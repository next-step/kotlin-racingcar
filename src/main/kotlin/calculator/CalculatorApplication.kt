package calculator

import calculator.domain.Calculator

fun main() {
    Main().start()
}

class Main(
    private val calculator: Calculator,
) {

    constructor() : this(
        Calculator()
    )

    fun start() {
        calculator.run()
    }
}

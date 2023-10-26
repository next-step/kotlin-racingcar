package calculator.application

class Calculator(
    private val console: Console,
    private val engine: Engine,
) {
    fun run() {
        while (true) {
            val expr: String = console.enterExpression()
            val result: String = engine.compute(expr)
            console.out(result)
        }
    }
}

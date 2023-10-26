package calculator.application

import java.lang.Exception

class Calculator(
    private val console: Console,
    private val engine: Engine,
) {
    fun run() {
        while (true) {
            try {
                val expr: String = console.enterExpression()
                val result: String = engine.compute(expr)
                console.out(result)
            } catch (e: Exception) {
                println("값을 입력하지 않았거나 잘못된 형식입니다.")
                continue
            }
        }
    }
}

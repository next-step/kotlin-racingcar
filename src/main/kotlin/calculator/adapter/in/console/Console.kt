package calculator.adapter.`in`.console

import calculator.application.port.`in`.CalculateUseCase
import calculator.application.port.`in`.CalculateCommand

class Console(
    private val calculateUseCase: CalculateUseCase,
) {
    fun run() {
        while (true) {
            try {
                val expr: String = enterExpression()

                val command = CalculateCommand(expr = expr)
                val result: String = calculateUseCase.compute(command)

                out(result)
            } catch (e: Exception) {
                println(e.message)
                continue
            }
        }
    }

    private fun enterExpression(): String {
        println("입력해 주세요.")
        return readln()
    }

    private fun out(result: String) {
        println(result)
    }
}

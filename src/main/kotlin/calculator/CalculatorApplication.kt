package calculator

import calculator.domain.Calculator

fun main() {
    val app = CalculatorApplication()
    app.run()
}

class CalculatorApplication() {

    fun run() {
        println("계산식을 입력 해주세요.")
        val input = readLine() ?: ""
        val operands = input.split(" ").filterIndexed { idx, _ -> idx % 2 == 0 }.toList()
        val operators = input.split(" ").filterIndexed { idx, _ -> idx % 2 == 1 }.toList()

        val calculator = Calculator(operands, operators)
        val result: Int = calculator.calculate()

        println("결과: $result")
    }
}

package calculator

import calculator.view.InputView

fun main() {
    val formula = Formula(InputView.input { readln() })

    val result = formula.calculateFormula()

    println("result = $result")
}

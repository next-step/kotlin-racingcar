package step2

import step2.view.getSplitStringForCalculate
import step2.view.printInsertStringForCalculate

fun main() {
    printInsertStringForCalculate()
    val symbols = getSplitStringForCalculate()
    println(StringCalculator.calculate(symbols))
}

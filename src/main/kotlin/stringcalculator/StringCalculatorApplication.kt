package stringcalculator

import stringcalculator.view.getSplitStringForCalculate
import stringcalculator.view.printInsertStringForCalculate

fun main() {
    printInsertStringForCalculate()
    val symbols = getSplitStringForCalculate()
    println(StringCalculator.calculate(symbols))
}

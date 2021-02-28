package calculator

import calculator.ui.SystemInputStrategy
import calculator.ui.UserInput

fun main() {
    println(Calculator(UserInput(SystemInputStrategy()).operate()).calculate())
}

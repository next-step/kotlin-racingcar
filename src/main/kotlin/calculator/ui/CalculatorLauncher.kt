package calculator

import input.SystemInputStrategy
import calculator.ui.UserInput

fun main() {
    println(Calculator(UserInput(SystemInputStrategy()).operate()).calculate())
}

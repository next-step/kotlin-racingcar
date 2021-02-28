package calculator

import input.SystemInputStrategy
import calculator.ui.UserInput

fun main() {
    Calculator(UserInput(SystemInputStrategy()).operate())
}

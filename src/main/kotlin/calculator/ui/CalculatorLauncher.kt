package calculator

import calculator.ui.SystemInputStrategy
import calculator.ui.UserInput

fun main() {
    Calculator(UserInput(SystemInputStrategy()).operate())
}

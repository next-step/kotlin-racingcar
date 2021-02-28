package calculator

fun main() {
    CalculatorLauncher(
        UserInput(SystemInputStrategy())
    ).launch()
}

class CalculatorLauncher(val userInput: UserInput) {
    fun launch() {
        Calculator()
    }
}

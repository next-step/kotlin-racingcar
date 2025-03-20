fun main() {
    val stringCalculator = StringCalculator()
    val calculatorParser = CalculatorParser()

    while (true) {
        try {
            print("please enter the expression: ")
            val expression = calculatorParser.parse(readln())
            val result = stringCalculator.calculate(expression)
            print("result: $result")
            return
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }
}

class Main {
}
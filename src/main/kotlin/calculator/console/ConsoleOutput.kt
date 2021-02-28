package calculator.console

import calculator.Number
import calculator.Output

class ConsoleOutput : Output {
    override fun write(number: Number) {
        println(number)
    }
}

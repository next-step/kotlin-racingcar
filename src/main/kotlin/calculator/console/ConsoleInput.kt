package calculator.console

import calculator.Input

class ConsoleInput : Input {
    override fun read(): String {
        return readLine() ?: ""
    }
}

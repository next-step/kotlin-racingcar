package calculator.interfaces.input.impl

import calculator.interfaces.input.InputConsole

object SingleInputConsole : InputConsole {

    override fun input() = readln()
}

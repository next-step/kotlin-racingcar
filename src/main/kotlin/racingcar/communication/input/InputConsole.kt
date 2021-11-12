package racingcar.communication.input

import java.util.Scanner

class InputConsole : Input {
    private val scan: Scanner = Scanner(System.`in`)

    override fun numberOfRacingCars(): Int = inputToCorrectIntValue()
    override fun finalLab(): Int = inputToCorrectIntValue()

    private fun inputToCorrectIntValue(): Int {
        var inputValue: Int

        do {
            inputValue = scanIntValue()
        } while (inputValue == COULD_NOT_READ)

        return inputValue
    }

    private fun scanIntValue(): Int {
        kotlin.runCatching {
            return scan.nextInt()
        }.onFailure {
            println(it.message)
            scan.next()
        }.getOrElse {
            return COULD_NOT_READ
        }
    }

    companion object {
        private const val COULD_NOT_READ = -1
    }
}

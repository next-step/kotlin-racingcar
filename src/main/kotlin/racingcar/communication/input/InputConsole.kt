package racingcar.communication.input

import racingcar.util.Parser.separateBySeparator
import racingcar.util.Validation.assertCarsNames
import java.util.Scanner

class InputConsole : Input {
    private val scan: Scanner = Scanner(System.`in`)

    override fun racingCarsNames(): List<String> = inputToCorrectStringValue()
    override fun numberOfRacingCars(): Int = inputToCorrectIntValue()
    override fun finalLab(): Int = inputToCorrectIntValue()

    private fun inputToCorrectStringValue(): List<String> {
        val carNames: MutableList<String> = mutableListOf()

        do {
            carNames.addAll(inputNamesOfCars())
        } while (carNames.isEmpty())

        return carNames
    }

    private fun inputNamesOfCars(): List<String> {
        runCatching {
            val carsNames = separateBySeparator(scan.nextLine())

            return assertCarsNames(carsNames)
        }.getOrElse {
            scan.next()
            return listOf()
        }
    }

    private fun inputToCorrectIntValue(): Int {
        var inputValue: Int

        do {
            inputValue = scanIntValue()
        } while (inputValue == COULD_NOT_READ)

        return inputValue
    }

    private fun scanIntValue(): Int {
        runCatching {
            return scan.nextInt()
        }.getOrElse {
            scan.next()
            return COULD_NOT_READ
        }
    }

    companion object {
        private const val COULD_NOT_READ = -1
    }
}

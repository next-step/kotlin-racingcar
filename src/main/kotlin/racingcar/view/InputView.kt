package racingcar.view

private const val MINIMUM_NUMBER_INPUT = 0
private const val MAXIMUM_NUMBER_INPUT = 10

object InputView {
    fun requestCarNames(): String {
        println("Enter the names of the cars (separated by commas):  ")
        return input()
    }

    fun requestNumberOfCars(): Int {
        println("How many cars are in the race?")
        return inputNumber()
    }

    fun requestNumberOfRounds(): Int {
        println("How many rounds will be played?")
        return inputNumber()
    }

    private fun input(): String {
        val input = readlnOrNull()
        require(!input.isNullOrBlank()) {
            "Input must not be null or empty."
        }

        return input
    }

    private fun inputNumber(): Int {
        val value =
            readlnOrNull()
                ?.toInt()
                ?: throw IllegalArgumentException("Invalid input. Value must be a number.")

        require(value in MINIMUM_NUMBER_INPUT..MAXIMUM_NUMBER_INPUT) {
            throw IllegalArgumentException(
                "Invalid input. Value must be between $MINIMUM_NUMBER_INPUT and $MAXIMUM_NUMBER_INPUT.",
            )
        }

        return value
    }
}

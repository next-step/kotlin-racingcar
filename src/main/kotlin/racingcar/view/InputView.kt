package racingcar.view

private const val MINIMUM_NUMBER_INPUT = 0
private const val MAXIMUM_NUMBER_INPUT = 10

object InputView {
    fun requestNumberOfCars(): Int {
        println("How many cars are in the race?")
        return input()
    }

    fun requestNumberOfRounds(): Int {
        println("How many rounds will be played?")
        return input()
    }

    private fun input(): Int {
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

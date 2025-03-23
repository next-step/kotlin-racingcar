package racingcar.view

private const val MINIMUM_NUMBER_INPUT = 0
private const val MAXIMUM_NUMBER_INPUT = 100

object InputView {
    fun requestCarNames(): List<String> {
        println("Enter the names of the cars (separated by commas):  ")
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No car names were provided.")

        return input.split(",")
            .filter { it.isNotBlank() }
            .map { it.trim() }
    }

    fun requestNumberOfRounds(): Int {
        println("How many rounds will be played?")
        return inputNumber()
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

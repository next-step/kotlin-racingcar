package racingcar

object InputInspector {
    private const val MIN_COUNT_OF_CAR_NAMES = 2
    private const val MIN_LENGTH_OF_CAR_NAME = 1
    private const val MAX_LENGTH_OF_CAR_NAME = 5

    var validNames = listOf<String>()

    fun validate(names: List<String>) {
        var names = names

        // need more than two names of cars
        while (isLessThanTwo(names)) {
            println(InputView.ENTER_CAR_NAMES_AGAIN)
            names = InputView.readCarNames(readLine())
        }
        // check whether the length of each fits length condition
        validateLengthOfEachName(names)

        validNames = names
    }

    private fun validateLengthOfEachName(names: List<String>): List<String> {
        var names = names
        names.forEach { name ->
            while (isLessThanMinLength(name)) {
                println(InputView.ENTER_CAR_NAMES_AGAIN)
                names = InputView.readCarNames(readLine())
            }
            while (isMoreThanMaxLength(name)) {
                println(InputView.ENTER_CAR_NAMES_AGAIN)
                names = InputView.readCarNames(readLine())
            }
        }
        return names
    }

    private fun isMoreThanMaxLength(name: String) = name.length > MAX_LENGTH_OF_CAR_NAME

    private fun isLessThanMinLength(name: String) = name.length < MIN_LENGTH_OF_CAR_NAME

    private fun isLessThanTwo(names: List<String>) = names.size < MIN_COUNT_OF_CAR_NAMES
}

package carracing.game.domain

object InputValidator {
    fun validateCarNames(input: String?): List<String> {
        val carsNames = input?.split(',')
        require(carsNames != null && carsNames.size >= MIN_CARS_AMOUNT) {
            "Cars amount should be at least $MIN_CARS_AMOUNT"
        }
        return carsNames
    }

    fun validateRoundsAmount(input: String?): Int {
        val inputInt = input?.toIntOrNull()
        require(inputInt != null && inputInt >= MIN_ROUNDS_AMOUNT) {
            "Rounds amount should be at least $MIN_ROUNDS_AMOUNT"
        }
        return inputInt
    }
}

internal const val MIN_CARS_AMOUNT = 2
internal const val MIN_ROUNDS_AMOUNT = 1

package racingcar.util

object Validation {
    private const val INVALID_CAR_NAME_ERROR_MESSAGE = "[ERROR] : invalid argument car name"

    fun assertCarsNames(carsNames: List<String>): List<String> {
        if (carsNames.isEmpty()) {
            throw IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE)
        }

        val correctCarsNames = carsNames.asSequence()
            .filter { name -> name.trim().isNotEmpty() }
            .toList()

        if (correctCarsNames.size != carsNames.size) {
            throw IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE)
        }

        return carsNames
    }
}

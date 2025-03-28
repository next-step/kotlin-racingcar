package racingcar.view

import racingcar.domain.Name

class InputView {
    fun getCarNumber(): Int? {
        println(MESSAGE_CAR_NUMBER)
        return readln().toIntOrNull()
    }

    fun getRoundNumber(): Int? {
        println(MESSAGE_ROUND_NUMBER)
        return readln().toIntOrNull()
    }

    fun getNames(): List<Name> {
        println(MESSAGE_CAR_NAME)
        return readln().split(DELIMITER).map { Name(it) }
    }

    companion object {
        private const val MESSAGE_CAR_NUMBER = "How many cars are in the race?"
        private const val MESSAGE_ROUND_NUMBER = "How many rounds will be played?"
        private const val MESSAGE_CAR_NAME = "Enter the names of the cars (separated by commas):  "
        private const val DELIMITER = " "
    }
}

package racingcar.view

import racingcar.domain.Name

class InputView {
    fun getRoundNumber(): Int? {
        println(MESSAGE_ROUND_NUMBER)
        return readln().toIntOrNull()
    }

    fun getNames(): List<Name> {
        println(MESSAGE_CAR_NAME)
        return readln().split(DELIMITER).map { Name(it.trim()) }
    }

    companion object {
        private const val MESSAGE_ROUND_NUMBER = "How many rounds will be played?"
        private const val MESSAGE_CAR_NAME = "Enter the names of the cars (separated by commas):  "
        private const val DELIMITER = ","
    }
}

package racingcar.domain

import racingcar.util.Message

class RacingPlayers(
    val names: List<String>
) {
    init {
        require(nameLengthIsLessOrEqualThan()) {
            Message.CAR_NAME_LENGTH_EXCEPTION.message
        }
    }

    private fun nameLengthIsLessOrEqualThan() = this.names.all { NAME_MAX_LENGTH >= it.length }
    companion object {
        private const val NAME_MAX_LENGTH = 5
        fun of(nameOfCars: String) =
            RacingPlayers(nameOfCars.split(","))
    }
}

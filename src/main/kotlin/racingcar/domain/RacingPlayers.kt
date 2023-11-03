package racingcar.domain

import racingcar.util.Message

class RacingPlayers(
    nameOfCars: String,
    val numberOfTrials: Int,
    validation: RacingPlayersValidation
) {

    val names: List<String>

    init {
        this.names = nameOfCars.split(",")
        require(validation.validate(this)) {
            Message.CAR_NAME_LENGTH_EXCEPTION.message
        }
    }
}

package racingcar

import racingcar.domain.NameValidation
import racingcar.domain.RacingPlayers
import racingcar.domain.RacingResult
import racingcar.domain.RacingRule
import racingcar.domain.RacingStadium
import racingcar.util.Message

class RacingController(
    private val racingPlayers: RacingPlayers,
    nameValidation: NameValidation
) {
    init {
        require(nameValidation.validate(racingPlayers.names)) {
            Message.CAR_NAME_LENGTH_EXCEPTION.message
        }
    }

    fun start(rule: RacingRule): RacingResult =
        RacingStadium(racingPlayers, rule).gameStart()
}

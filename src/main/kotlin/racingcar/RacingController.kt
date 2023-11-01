package racingcar

import racingcar.domain.RacingRule
import racingcar.domain.RacingStadium
import racingcar.domain.RacingResult
import racingcar.util.Message

class RacingController(
    private val nameOfCars: String,
    private val numberOfTrials: Int
) {

    fun start(rule: RacingRule): RacingResult {
        val names = nameOfCars.split(",")
        require(rule.nameValidate(names)) {
            Message.CAR_NAME_LENGTH_EXCEPTION.message
        }

        return RacingStadium(
            names,
            numberOfTrials,
            rule
        ).gameStart()
    }

}

package racingcar

import racingcar.domain.RacingPlayers
import racingcar.domain.RacingResult
import racingcar.domain.RacingRule
import racingcar.domain.RacingStadium

class RacingController(
    private val racingPlayers: RacingPlayers
) {

    fun start(rule: RacingRule): RacingResult =
        RacingStadium(racingPlayers, rule).gameStart()
}

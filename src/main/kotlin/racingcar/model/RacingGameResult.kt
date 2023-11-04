package racingcar.model

import racingcar.model.log.RoundLog

data class RacingGameResult(
    val winners: List<Car>,
    val roundLogs: List<RoundLog>
)

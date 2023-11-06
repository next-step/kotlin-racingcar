package racingcar.model

import racingcar.model.log.RoundLog

data class RacingcarGameResult(
    val winners: List<Car>,
    val roundLogs: List<RoundLog>
)

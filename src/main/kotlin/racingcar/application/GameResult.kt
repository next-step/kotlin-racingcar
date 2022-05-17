package racingcar.application

import racingcar.domain.Record

data class GameResult(
    val winners: List<String>,
    val records: List<Record>,
)

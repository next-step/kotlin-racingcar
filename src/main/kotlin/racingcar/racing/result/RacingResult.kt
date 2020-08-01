package racingcar.racing.result

import racingcar.turn.Turn

class RacingResult(val turns: List<Turn>) {
    val winners get() = turns.last().cars
}

package racingcar.view

import racingcar.dto.RacingGameRequest

object InputView {
    private const val CAR_COUNT_REQUEST = "자동차 대수는 몇 대 인가요?"
    private const val LAPS_REQUEST = "시도할 회수는 몇 회 인가요?"

    fun input(): RacingGameRequest {
        return RacingGameRequest(inputCarCount(), inputLaps())
    }

    private fun inputCarCount(): Int {
        println(CAR_COUNT_REQUEST)
        return readln().toInt()
    }

    private fun inputLaps(): Int {
        println(LAPS_REQUEST)
        return readln().toInt()
    }
}

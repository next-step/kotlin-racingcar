package racingcar.view

import racingcar.dto.RacingGameRequest

object InputView {
    private const val CAR_NAMES_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val LAPS_REQUEST = "시도할 회수는 몇 회 인가요?"

    fun input(): RacingGameRequest {
        return RacingGameRequest(inputCarNames(), inputLaps())
    }

    private fun inputCarNames(): String {
        println(CAR_NAMES_REQUEST)
        return readln()
    }

    private fun inputLaps(): Int {
        println(LAPS_REQUEST)
        return readln().toInt()
    }
}

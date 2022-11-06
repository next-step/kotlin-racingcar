package racingcar.ui

import racingcar.racingcar.CarRacingRequest

class InputView {
    fun getRequest(): CarRacingRequest {
        println(INPUT_PARTICIPANTS_GUIDE)
        val totalParticipants = readln().toInt()

        println(INPUT_TRY_COUNT_GUIDE)
        val tryCount = readln().toInt()

        return CarRacingRequest(totalParticipants, tryCount)
    }

    private companion object {
        const val INPUT_PARTICIPANTS_GUIDE = "자동차 대수는 몇 대 인가요?"
        const val INPUT_TRY_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?"
    }
}

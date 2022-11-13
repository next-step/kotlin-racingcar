package racingcar.ui

import racingcar.racingcar.CarRacingRequest

class InputView {
    fun getRequest(): CarRacingRequest {
        println(INPUT_PARTICIPANTS_GUIDE)
        val totalParticipants = readln().toInt()
        validateInput(totalParticipants)

        println(INPUT_TRY_COUNT_GUIDE)
        val turnCount = readln().toInt()
        validateInput(turnCount)

        return CarRacingRequest(totalParticipants, turnCount)
    }

    private fun validateInput(input: Int) {
        if (input < 0) {
            throw IllegalArgumentException("음수를 입력하였습니다. 0보다 큰 숫자를 입력해주세요.")
        }
    }

    private companion object {
        const val INPUT_PARTICIPANTS_GUIDE = "자동차 대수는 몇 대 인가요?"
        const val INPUT_TRY_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?"
    }
}

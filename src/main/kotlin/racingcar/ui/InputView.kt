package racingcar.ui

import racingcar.racingcar.CarRacingRequest

class InputView {
    fun getRequest(): CarRacingRequest {
        println(INPUT_PARTICIPANTS_GUIDE)
        val carNameString = readln()

        val carNames = splitCarNames(carNameString)

        println(INPUT_TRY_COUNT_GUIDE)
        val turnCount = readln().toInt()
        validateTurnCount(turnCount)

        return CarRacingRequest(carNames, turnCount)
    }

    private companion object {
        const val INPUT_PARTICIPANTS_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?"

        private fun splitCarNames(input: String): List<String> {
            return input.split(",")
        }

        private fun validateTurnCount(input: Int) {
            if (input < 0) {
                throw IllegalArgumentException("시도 회수에 음수를 입력하였습니다. 0보다 큰 숫자를 입력해주세요.")
            }
        }
    }
}

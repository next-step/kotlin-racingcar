package racingcar

object RacingCarInputView {
    fun input(): RacingCarRequest {
        print("경주에 참여할 자동차 대수는 몇 대인가요? ")
        val carNamesInput = readLine()
        print("경주는 몇 라운드를 진행할 것인가요? ")
        val roundsInput = readLine()
        return RacingCarRequest.of(carNames = carNamesInput, rounds = roundsInput)
    }
}

class RacingCarRequest(val carNames: String, val rounds: Int) {
    companion object {
        fun of(carNames: String?, rounds: String?): RacingCarRequest {
            validateCarNames(carNamesInput = carNames)
            validateRounds(roundsInput = rounds)
            return RacingCarRequest(carNames!!, rounds!!.toInt())
        }

        private fun validateCarNames(carNamesInput: String?) {
            require(!carNamesInput.isNullOrBlank()) { "자동차 이름은 입력값은 빈 값이거나, 공백일 수 없습니다." }
        }

        private fun validateRounds(roundsInput: String?) {
            require(!roundsInput.isNullOrBlank()) { "라운드 입력값은 빈 값이거나, 공백일 수 없습니다." }
            val rounds = roundsInput.toIntOrNull()
                ?: throw IllegalArgumentException("라운드 입력값은 정수여야 합니다.")
            require(rounds > 0) { "라운드 입력값은 0보다 큰 값이어야 합니다." }
        }
    }
}

package racingcar

object RacingCarInputView {
    fun input(): RacingCarRequest {
        print("경주에 참여할 자동차 대수는 몇 대인가요? ")
        val numberOfParticipantsInput = readLine()
        print("경주는 몇 라운드를 진행할 것인가요? ")
        val roundsInput = readLine()
        return RacingCarRequest.of(numberOfParticipantsInput, roundsInput)
    }
}

class RacingCarRequest(val numberOfParticipants: Int, val rounds: Int) {
    companion object {
        fun of(numberOfParticipants: String?, rounds: String?): RacingCarRequest {
            validateNumberOfParticipants(numberOfParticipants)
            validateRounds(rounds)
            return RacingCarRequest(numberOfParticipants!!.toInt(), rounds!!.toInt())
        }

        private fun validateNumberOfParticipants(numberOfParticipantsInput: String?) {
            require(!numberOfParticipantsInput.isNullOrBlank()) { "자동차 대수 입력값은 빈 값이거나, 공백일 수 없습니다." }
            val numberOfParticipants = numberOfParticipantsInput.toIntOrNull()
                ?: throw IllegalArgumentException("자동차 대수 입력값은 정수여야 합니다.")
            require(numberOfParticipants > 0) { "자동차 대수 입력값은 0보다 큰 값이어야 합니다." }
        }

        private fun validateRounds(roundsInput: String?) {
            require(!roundsInput.isNullOrBlank()) { "라운드 입력값은 빈 값이거나, 공백일 수 없습니다." }
            val rounds = roundsInput.toIntOrNull()
                ?: throw IllegalArgumentException("라운드 입력값은 정수여야 합니다.")
            require(rounds > 0) { "라운드 입력값은 0보다 큰 값이어야 합니다." }
        }
    }
}

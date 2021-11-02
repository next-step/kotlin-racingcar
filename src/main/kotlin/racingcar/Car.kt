package racingcar

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(attemptNumber: Int) {
        validateAttemptNumber(attemptNumber)
        if (attemptNumber >= MOVE_THRESHOLD) {
            position++
        }
    }

    fun validateAttemptNumber(attemptNumber: Int) {
        require(attemptNumber in ATTEMPT_NUMBER_RANGE) { "전진 시도 숫자는 0과 9사이의 값이어야 합니다." }
    }

    companion object {
        const val DEFAULT_POSITION = 1
        const val MOVE_THRESHOLD = 4
    }
}

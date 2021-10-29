package racingcar

class Car(var position: Int = DEFAULT_POSITION) {
    fun move(randomValue: Int) {
        require(randomValue in RANDOM_RANGE) { "전진 시도 숫자는 0과 9사이의 값이어야 합니다." }
        if (randomValue >= MOVE_THRESHOLD) {
            position++
        }
    }

    companion object {
        const val DEFAULT_POSITION = 1
        const val MOVE_THRESHOLD = 4
    }
}

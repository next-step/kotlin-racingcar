package step3.racing_car

/**
 * 자동차 경주의 자동차로 사용
 * */
class Car(position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    /**
     * 자동차의 위치를 변경
     * */
    fun move(condition: Int) {
        require(condition in (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE))
        if (condition >= ADVANCE_MIN_VALUE) {
            position++
        }
    }

    companion object {
        private const val ADVANCE_MIN_VALUE = 4
        private const val DEFAULT_POSITION = 0
    }
}
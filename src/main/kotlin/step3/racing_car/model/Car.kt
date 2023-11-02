package step3.racing_car.model

import step3.racing_car.interfaces.Movable

/**
 * 자동차 경주의 자동차로 사용
 * */
data class Car(private var position: Int = DEFAULT_POSITION): Movable {

    /**
     * 자동차의 위치를 변경
     * */
    override fun move(condition: Int) {
        require(condition in (MIN_MOVE_VALUE..MAX_MOVE_VALUE))
        if (condition >= ADVANCE_MIN_VALUE) {
            position++
        }
    }

    /**
     * 자동차의 위치를 반환
     * */
    override fun getCurrentPosition() = position

    companion object {
        private const val ADVANCE_MIN_VALUE = 4
        private const val DEFAULT_POSITION = 0
        private const val MIN_MOVE_VALUE = 0
        private const val MAX_MOVE_VALUE = 9
    }
}
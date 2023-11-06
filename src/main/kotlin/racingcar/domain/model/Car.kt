package racingcar.domain.model

import racingcar.domain.interfaces.Raceable

/**
 * 자동차 객체
 * */
class Car(override val name: String, override var position: Int = DEFAULT_POSITION): Raceable {

    /**
     * 위치 변경
     * */
    override fun move(condition: Int) {
        require(condition in (MIN_MOVE_VALUE..MAX_MOVE_VALUE))
        if (condition >= ADVANCE_MIN_VALUE) {
            position++
        }
    }

    companion object {
        private const val ADVANCE_MIN_VALUE = 4
        private const val DEFAULT_POSITION = 0
        private const val MIN_MOVE_VALUE = 0
        private const val MAX_MOVE_VALUE = 9
    }
}
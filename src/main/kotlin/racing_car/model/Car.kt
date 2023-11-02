package racing_car.model

import racing_car.interfaces.Movable

/**
 * 자동차 경주의 자동차로 사용
 * */
class Car(private val name: String, private var position: Int = DEFAULT_POSITION): Movable {
    init {
        require(name.isNotBlank() && name.length < 6)
    }

    /**
     * 자동차의 위치를 반환
     * */
    override fun getCurrentPosition() = position

    /**
     * 자동차의 이름을 반환
     * */
    override fun getName(): String = name

    /**
     * 자동차의 위치를 변경
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
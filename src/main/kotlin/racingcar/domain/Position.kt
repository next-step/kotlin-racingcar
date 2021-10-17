package racingcar.domain

import kotlin.math.max

/**
 * 위치.
 */
data class Position(val value: Int = 0) {
    init {
        require(value >= 0)
    }

    /**
     * 위치를 이동하고 리턴한다.
     */
    fun move(newPosition: Int): Position {
        return Position(value + newPosition)
    }

    /**
     * 최대 위치값인지 비교하여 위치를 리턴합니다.
     *
     * @param comparePosition 비교하고자하는 위치
     * @return 최대 위치값
     */
    fun getMaxPosition(comparePosition: Int): Int {
        return max(comparePosition, value)
    }

    /**
     * 최대값이라면 true, 아니라면 false를 반환합니다.
     *
     * @param maxPosition 비교하고자하는 최대 위치값
     * @return 최대값 여부
     */
    fun isMaxPosition(maxPosition: Int): Boolean {
        return value == maxPosition
    }
}

package racingcar

import org.jetbrains.annotations.TestOnly

class Car(val name: String = "") {

    init {
        if (name.length > 5) throw IllegalArgumentException("차 이름이 최대 5글자까지 입력 가능합니다.")
        if (name.isEmpty()) throw IllegalArgumentException("차 이름이 유효하지 않습니다.")
    }

    private val _distanceCounts = mutableListOf(0)
    val distanceCounts: List<Int> get() = _distanceCounts

    fun updateDistanceCount() {
        if (availableMoving()) {
            _distanceCounts.add(_distanceCounts.last() + 1)
        } else {
            _distanceCounts.add(_distanceCounts.last())
        }
    }

    @TestOnly
    fun setupDistanceCondition() {
        _distanceCounts.add(MOVING_CONDITION_MIN_NUM)
    }

    @TestOnly
    fun setupDistanceLimitCondition() {
        _distanceCounts.add(MOVING_CONDITION_MIN_NUM - 1)
    }

    private fun availableMoving(): Boolean = MOVING_CONDITION_RANGE.random() >= MOVING_CONDITION_MIN_NUM

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
        private const val MOVING_CONDITION_MIN_NUM = 4
    }
}

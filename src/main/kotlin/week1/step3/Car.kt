package week1.step3

import org.jetbrains.annotations.TestOnly

class Car(val name: String = "") {

    init {
        if (name.length > 5) throw IllegalArgumentException("차 이름이 최대 5글자까지 입력 가능합니다.")
        if (name.isEmpty()) throw IllegalArgumentException("차 이름이 유효하지 않습니다.")
    }

    private val _forwardCounts = mutableListOf(0)
    val forwardCounts: List<Int> get() = _forwardCounts

    fun updateForwardCount() {
        if (availableForward()) {
            _forwardCounts.add(_forwardCounts.last() + 1)
        } else {
            _forwardCounts.add(_forwardCounts.last())
        }
    }

    @TestOnly
    fun setupForwardCondition() {
        _forwardCounts.add(FORWARD_CONDITION_MIN_NUM)
    }

    @TestOnly
    fun setupForwardLimitCondition() {
        _forwardCounts.add(FORWARD_CONDITION_MIN_NUM - 1)
    }

    private fun availableForward(): Boolean = FORWARD_CONDITION_RANGE.random() >= FORWARD_CONDITION_MIN_NUM

    companion object {
        private val FORWARD_CONDITION_RANGE = 0..9
        private const val FORWARD_CONDITION_MIN_NUM = 4
    }
}

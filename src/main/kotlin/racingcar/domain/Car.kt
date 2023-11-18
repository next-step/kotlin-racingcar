package racingcar.domain

class Car {
    var distance = 0

    private val point = 4

    fun move(num: Int): Int {
        return if (isMoved(num)) {
            ++distance
        } else {
            distance
        }
    }

    private fun isMoved(num: Int): Boolean {
        return num >= point
    }
}

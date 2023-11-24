package racingcar.domain

class Car {
    private var distance = 0

    fun move(num: Int): Int {
        return if (isMoved(num)) {
            ++distance
        } else {
            distance
        }
    }

    private fun isMoved(num: Int): Boolean {
        return num >= POINT
    }

    companion object {
        const val POINT = 4
    }
}

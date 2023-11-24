package racingcar.domain

class Car(
    val name: String,
) {
    private var distance = 0

    val getDistance: Int
        get() = distance

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

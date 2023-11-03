package race.domain

import java.lang.IllegalArgumentException

class SimpleCar(val name: String) {
    private var location = 0

    init {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다")
        }
    }

    fun getLocation() = location

    fun move(value: Int) {
        if (value >= MOVE_THRESHOLD) location++
    }

    companion object {
        const val MOVE_THRESHOLD = 4
    }
}

package race.domain

import java.lang.IllegalArgumentException

class SimpleCar(val name: String) {
    var location = 0
        private set

    init {
        if (name.length > NAME_MAX_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 ${NAME_MAX_LENGTH}자를 초과할 수 없습니다")
        }
    }

    fun move(value: Int) {
        if (value >= MOVE_THRESHOLD) location++
    }

    companion object {
        const val MOVE_THRESHOLD = 4
        const val NAME_MAX_LENGTH = 5
    }
}

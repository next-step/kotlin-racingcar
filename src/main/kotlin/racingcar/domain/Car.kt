package racingcar.domain

class Car(val name: String = "", val position: Int = 0) {

    fun move(value: Int): Car {
        if (value >= MOVING_THRESHOLD) {
            return Car(name, position + 1)
        }
        return this
    }

    companion object {
        private const val MOVING_THRESHOLD = 4
    }
}

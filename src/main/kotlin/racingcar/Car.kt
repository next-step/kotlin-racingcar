package racingcar

class Car(val name: String) {
    var currentPosition: Int = 0
        private set

    init {
        validateName(name)
    }

    fun accelerate(fuel: Int) {
        if (canAccelerate(fuel)) {
            increaseCurrentPosition()
        }
    }

    private fun validateName(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }

    private fun canAccelerate(fuel: Int): Boolean {
        return fuel >= MIN_FUEL_THRESHOLD
    }

    private fun increaseCurrentPosition() {
        currentPosition += 1
    }

    companion object {
        const val MIN_FUEL_THRESHOLD = 4
    }
}

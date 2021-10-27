package racingcar

class Car(val name: String) {
    var currentPosition: Int = 0
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun accelerate(fuel: Int) {
        if (canAccelerate(fuel)) {
            increaseCurrentPosition()
        }
    }

    private fun canAccelerate(fuel: Int): Boolean {
        return fuel >= MIN_FUEL_THRESHOLD
    }

    private fun increaseCurrentPosition() {
        currentPosition++
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_FUEL_THRESHOLD = 4
    }
}

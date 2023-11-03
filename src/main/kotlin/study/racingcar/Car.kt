package study.racingcar

data class Car(val name: String, val position: Int = 0) {
    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters" }
    }
    fun move(randomValue: Int): Car {
        return if (randomValue >= MOVABLE_BASE_NUMBER) {
            copy(position = position + 1)
        } else {
            this
        }
    }

    private companion object {
        const val MOVABLE_BASE_NUMBER = 4
    }
}

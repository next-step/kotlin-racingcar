package study.racingcar

data class Car(val position: Int = 0) {
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

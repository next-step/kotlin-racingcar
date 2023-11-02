package study.racingcar

data class Car(val position: Int = 0) {
    fun move(randomValue: Int): Car {
        return if (randomValue >= 4) {
            copy(position = position + 1)
        } else {
            this
        }
    }
}

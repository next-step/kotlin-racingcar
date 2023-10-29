package racingcar.model

data class Car(
    var position: Int = 0,
) {
    fun move() {
        position++
    }

    companion object {
        fun of(): Car {
            return Car()
        }
    }
}

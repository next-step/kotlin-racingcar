package racingcar.domain

data class Car(
    val position: Int = 1,
) {

    fun move(point: Int): Car {
        if (point >= 4) {
            return Car(position + 1)
        }
        return this
    }
}

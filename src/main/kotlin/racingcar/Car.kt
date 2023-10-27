package racingcar

class Car(private val position: Int = 0) {

    fun move(): Car {
        return Car(position + 1)
    }

    fun print(): String {
        return "-".repeat(position)
    }
}

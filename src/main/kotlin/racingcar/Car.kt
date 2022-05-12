package racingcar

data class Car(val position: Int) {

    fun move(): Car = Car(position + 1)
}

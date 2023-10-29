package racingCar.domain

class Car(val name: String) {

    var moveCount: Int = 0
        private set

    fun move(): Int = ++moveCount
}

package racingCar.domain

class Car {

    var moveCount: Int = 0
        private set

    fun move(): Int = moveCount++
}

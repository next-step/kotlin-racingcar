package racingCar.model

interface MoveStrategy {
    fun move(mileage: Int): Int
}

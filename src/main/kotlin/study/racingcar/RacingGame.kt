package study.racingcar

class RacingGame(private val moveStrategy: MoveStrategy) {

    fun raceCars(cars: List<Car>): List<Car> {
        val mutableCars = cars.toMutableList()
        for (car in mutableCars) {
            moveCarOrNot(car, moveStrategy.isMoveCar())
        }
        return mutableCars.toList()
    }

    fun moveCarOrNot(car: Car, isMove: Boolean) {
        if (isMove) car.moveCar()
    }
}

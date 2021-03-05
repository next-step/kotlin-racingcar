package study.racingcar.domain

class RacingGame(private val moveStrategy: MoveStrategy) {

    fun raceCars(cars: List<Car>): List<Car> {
        val movableCars = cars.toMutableList()
        for (car in movableCars) {
            moveCarOrNot(car, moveStrategy.isMoveCar())
        }
        return movableCars.toList()
    }

    fun moveCarOrNot(car: Car, isMove: Boolean) {
        if (isMove) car.moveCar()
    }
}

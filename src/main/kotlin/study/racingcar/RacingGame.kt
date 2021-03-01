package study.racingcar

class RacingGame(private val moveStrategy: MoveStrategy) {

    private lateinit var _cars: Array<Car>

    fun readyGame(carCount: Int): Boolean {
        _cars = Array(carCount) { Car() }
        return true
    }

    fun raceCars(): List<Car> {
        for (car in _cars) {
            moveCarOrNot(car, moveStrategy.isMoveCar())
        }
        return _cars.toList()
    }

    fun moveCarOrNot(car: Car, isMove: Boolean) {
        if (isMove) car.moveCar()
    }
}

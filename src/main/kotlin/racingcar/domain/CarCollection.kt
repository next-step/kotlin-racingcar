package racingcar.domain

class CarCollection(carCount: Int) {

    private val cars: List<Car> = List(carCount) { Car() }

    fun tryMoveCars(conditionNumbers: List<Int>) {
        cars.zip(conditionNumbers).forEach { (car, number) ->
            car.tryMove(number)
        }
    }

    fun getCarsPosition(): List<Int> {
        return cars.map(Car::position)
    }
}

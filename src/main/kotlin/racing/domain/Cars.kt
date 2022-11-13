package racing.domain

class Cars(
    val cars: List<Car>
) {

    fun tryMoveCars(conditionNumbers: List<Int>) {
        cars.zip(conditionNumbers)
            .forEach {
                (car, isCarMoved) ->
                car.tryMove(isCarMoved)
            }
    }

    fun getCarsPosition(): List<Int> {
        return cars.map(Car::position)
    }
}

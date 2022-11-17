package racing.domain

class Cars(
    val cars: List<Car>
) {
    private val MOVING_CONDITION = 4

    fun tryMoveCars(conditionNumbers: List<Int>) {
        cars.zip(conditionNumbers)
            .forEach {
                (car, isCarMoved) ->
                if (isCarMoved >= MOVING_CONDITION) car.move()
            }
    }

    fun getCarsPosition(): List<Int> {
        return cars.map(Car::position)
    }
}

package racingcar.model

import kotlin.random.Random

class Cars(private var cars: List<Car>
) {
    fun moveForwardCars() {
        cars.forEach {
            it.moveForward(RandomValueMovingStrategy(getRandomNum()))
        }
    }

    private fun getRandomNum(): Int {
        return Random.nextInt(Car.MAX_BOUND)
    }

    fun forEach(action : (Car) -> (Unit)) = cars.forEach(action)
}

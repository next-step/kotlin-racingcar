package racingcar.model

import kotlin.random.Random

class Cars(
    carCount: CarCount
) {
    var cars: List<Car> = List(carCount.count) { Car(id = it) }

    fun moveForwardCars() {
        cars.forEach {
            it.moveForward(RandomValueMovingStrategy(getRandomNum()))
        }
    }

    private fun getRandomNum(): Int {
        return Random.nextInt(Car.MAX_BOUND)
    }
}

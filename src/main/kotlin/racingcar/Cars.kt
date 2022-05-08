package racingcar

import kotlin.random.Random

class Cars(
    private val carCount: CarCount
) {
    var cars: List<Car> = List(carCount.count) { Car(id = it) }

    fun moveCars() {
        cars.forEach {
            it.move(RandomValueMovingStrategy(getRandomNum()))
        }
    }

    private fun getRandomNum(): Int {
        return Random.nextInt(Car.MAX_BOUND)
    }
}

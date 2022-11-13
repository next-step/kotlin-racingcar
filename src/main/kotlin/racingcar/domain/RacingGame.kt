package racingcar.domain

import racingcar.ForwardStrategy

class RacingGame(
    private val cars: List<Car>,
    private val random: ForwardStrategy
) {

    fun play(playCount: Int, callback: (List<Car>) -> Unit = {}): List<Car> =
        this.play(this.cars, playCount, callback)

    private tailrec fun play(cars: List<Car>, playCount: Int, callback: (List<Car>) -> Unit): List<Car> {
        if (playCount == 0) return cars

        val movedCars = this.move(cars)
        callback(movedCars)

        return this.play(movedCars, playCount.dec(), callback)
    }

    private fun move(cars: List<Car>): List<Car> =
        cars.map { car ->
            car.move(this.random.generateInt())
        }
}

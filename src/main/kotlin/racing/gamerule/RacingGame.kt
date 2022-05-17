package racing.gamerule

import racing.Car

object RacingGame {
    fun play(cars: List<Car>, movingStrategy: MovingStrategy) {
        cars.forEach { car ->
            if (movingStrategy.isMovable()) {
                car.move()
            } else {
                car.stop()
            }
        }
    }

    fun getWinner(cars: List<Car>): List<String> {
        val max = cars.maxOf { it.getMoved() }
        return cars.filter { it.getMoved() == max }.map { it.carName }
    }
}

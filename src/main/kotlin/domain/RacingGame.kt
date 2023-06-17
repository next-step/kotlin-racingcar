package domain

import util.RandomNumber

class RacingGame(
    private var cars: List<Car>
) {

    fun getCars() = cars

    fun racing(): List<Car> {
        cars.map { car ->
            car.move(RandomNumber().getRandomNumber())
        }
        return cars
    }
}

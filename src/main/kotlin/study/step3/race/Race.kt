package study.step3.race

import study.step3.car.Car
import study.step3.car.CarFactory

class Race(
    private val numberOfCars: Int,
    private val numberOfAttempts: Int,
    private val moveGenerator: MoveGenerator,
    private val carFactory: CarFactory
) {
    private val cars: List<Car> = carFactory.createCars(numberOfCars)

    fun startRace(): List<List<String>> {
        val raceResults = mutableListOf<List<String>>()

        for (i in 1..numberOfAttempts) {
            cars.forEach { car ->
                car.move(moveGenerator.canMove())
            }
            raceResults.add(cars.map { it.getVisualPosition() })
        }
        return raceResults
    }
}

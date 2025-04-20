package controller

import model.Car

class RacingController {

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    fun startRace(cars: List<Car>, attemptCount: Int): List<String> {
        val results = mutableListOf<String>()
        repeat(attemptCount) {
            val roundResult = StringBuilder()
            cars.forEach { car ->
                car.move()
                roundResult.append("${car.name} : ${"-".repeat(car.getPosition())}\n")
            }
            results.add(roundResult.toString())
        }
        return results
    }

    fun getWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        return cars.filter { it.getPosition() == maxPosition }
    }
}
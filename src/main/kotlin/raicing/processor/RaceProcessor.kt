package raicing.processor

import raicing.model.Car
import raicing.model.RaceResult

class RaceProcessor {

    fun initCars(carCount: Int): List<Car> {
        return List(carCount) { Car(it) }
    }

    fun race(cars: List<Car>, raceCount: Int): List<RaceResult> {
        val raceResults = mutableListOf<RaceResult>()

        repeat(raceCount) {
            val raceResult = raceOnce(cars)
            raceResults.add(raceResult)
        }

        return raceResults
    }

    private fun raceOnce(cars: List<Car>): RaceResult {
        val raceResult = cars.map { car ->
            goOrStop(car)
            car.deepCopy()
        }

        return RaceResult(raceResult)
    }

    private fun goOrStop(car: Car) {
        val randomNum = getRandomMoveNumber()
        car.moveForwardDependingOption(randomNum)
    }

    private fun getRandomMoveNumber(): Int {
        return (MIN_RANDOM_BOUND..MAX_RANDOM_BOUND).random()
    }

    companion object {
        const val MIN_RANDOM_BOUND = 1
        const val MAX_RANDOM_BOUND = 10
    }
}

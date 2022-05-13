package raicing.processor

import raicing.model.Car
import raicing.model.RaceResult

class RaceProcessor {
    fun raceStart(carCount: Int, raceCount: Int): List<RaceResult> {

        val cars = initCars(carCount)
        val raceResults = mutableListOf<RaceResult>()

        repeat(raceCount) {
            val raceResult = race(cars)
            raceResults.add(raceResult)
        }

        return raceResults
    }

    private fun initCars(carCount: Int): List<Car> {
        return List(carCount) { Car(it) }
    }

    private fun race(cars: List<Car>): RaceResult {
        val raceResult = cars.map { car ->
            goOrStop(car)
            car

//            val afterCar = car.copy()
//            afterCar.position = car.position
//            afterCar
        }

        return RaceResult(raceResult)
    }

    private fun goOrStop(car: Car) {
        val randomNum = getRandomMoveNumber()
        if (randomNum >= BASE_NUM) car.moveForward()
    }

    private fun getRandomMoveNumber(): Int {
        return (MIN_RANDOM_BOUND..MAX_RANDOM_BOUND).random()
    }

    companion object {
        const val MIN_RANDOM_BOUND = 1
        const val MAX_RANDOM_BOUND = 10
        const val BASE_NUM = 4
    }
}

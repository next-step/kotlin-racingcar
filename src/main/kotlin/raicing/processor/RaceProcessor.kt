package raicing.processor

import raicing.model.Car
import raicing.model.RaceResult

class RaceProcessor {
    fun raceStart(carCnt: Int, raceCnt: Int): List<RaceResult> {

        val carList = initCarList(carCnt)
        val raceResultList = mutableListOf<RaceResult>()

        repeat(raceCnt) {
            val raceResult = race(carList)
            raceResultList.add(raceResult)
        }

        return raceResultList
    }

    private fun initCarList(carCnt: Int): List<Car> {
        val carList = mutableListOf<Car>()
        repeat(carCnt) {
            carList.add(Car(it))
        }
        return carList
    }

    private fun race(carList: List<Car>): RaceResult {
        val raceResult = carList.map { car ->
            goOrStop(car)

            val afterCar = car.copy()
            afterCar.position = car.position
            afterCar
        }

        return RaceResult(raceResult)
    }

    private fun goOrStop(car: Car) {
        val randomCnt = getRandomMoveNumber()
        if (randomCnt >= BASE_NUM) car.position++
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

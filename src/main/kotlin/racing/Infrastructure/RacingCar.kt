package racing.Infrastructure

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RacingState
import racing.domain.Winner
import kotlin.random.Random

class RacingCar {

    companion object {
        const val MINIMUM_RANGE_NUMBER = 0
        const val MAXIMUM_RANGE_NUMBER = 9
        const val MOVE_CONDITION_NUMBER = 4
    }

    fun start(racingState: RacingState): List<Cars> {

        var result = mutableListOf<Cars>()

        // Car Instance List 생성
        val cars = makeCarList(racingState)

        // 전진 시도
        repeat(racingState.attempt!!) {
            val list = move(cars)
            result.add(list)
        }

        return result
    }

    fun makeCarList(racingState: RacingState): List<Car> {
        return racingState.names.map { name -> Car(name) }
    }

    fun move(carList: List<Car>): List<Car> {
        return carList.map { car ->
            if (canIMove()) {
                car.distance++
            }
            Car(car.name, car.distance)
        }
    }

    fun canIMove(): Boolean {
        val random = Random.nextInt(
            MINIMUM_RANGE_NUMBER,
            MAXIMUM_RANGE_NUMBER
        )
        if (random >= MOVE_CONDITION_NUMBER) {
            return true
        }
        return false
    }

    fun getWinner(result: List<Cars>): List<Winner> {
        val sortedBy = sortedByDistanceDesc(result.last())
        val longestDistance = longestDistance(sortedBy)

        return sortedBy
            .filter { car -> car.distance == longestDistance }
            .map { car -> Winner(car.name) }
    }

    fun sortedByDistanceDesc(finalDistanceCars: Cars): List<Car> {
        return finalDistanceCars.sortedByDescending { it.distance }
    }

    fun longestDistance(sortedBy: List<Car>) = sortedBy.first().distance
}

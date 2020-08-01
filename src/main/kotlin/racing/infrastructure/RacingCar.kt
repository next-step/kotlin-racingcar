package racing.infrastructure

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
        repeat(racingState.attempt) {
            val list = move(cars)
            result.add(list)
        }

        return result
    }

    fun makeCarList(racingState: RacingState): Cars {
        return racingState.names.map { name -> Car(name) }
    }

    fun move(carList: Cars): Cars {
        return carList.map {
            if (canIMove()) {
                it.distance++
            }
            Car(it.name, it.distance)
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
        val cars = result.last()
        val longestDistance = longestDistance(cars)

        return cars
            .filter { it.distance == longestDistance }
            .map { Winner(it.name) }
    }

    fun longestDistance(cars: Cars): Int? {
        return cars.map { it.distance }.max()
    }
}

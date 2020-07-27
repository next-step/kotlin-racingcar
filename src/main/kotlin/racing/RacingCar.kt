package racing

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
        val cars = makeCarList(racingState.number!!)

        // 전진 시도
        repeat(racingState.attempt!!) {
            val list = move(cars)
            result.add(list)
        }

        return result
    }

    fun makeCarList(number: Int): List<Car> {
        return (0 until number).map {
            Car(it)
        }
    }

    fun move(carList: List<Car>): List<Car> {
        return carList.map { car ->
            if (canIMove()) {
                car.distance = car.distance + "-"
            }
            Car(car.number, car.distance)
        }
    }

    fun canIMove(): Boolean {
        val random = Random.nextInt(MINIMUM_RANGE_NUMBER, MAXIMUM_RANGE_NUMBER)
        if (random >= MOVE_CONDITION_NUMBER) {
            return true
        }
        return false
    }
}

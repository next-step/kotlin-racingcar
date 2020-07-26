package racing

import kotlin.random.Random

class RacingCar {

    companion object {
        const val MINIMUM_RANGE_NUMBER = 0
        const val MAXIMUM_RANGE_NUMBER = 9
        const val MOVE_CONDITION_NUMBER = 4
    }

    fun start(racingState: RacingState): List<List<Car>> {
        var result = mutableListOf<List<Car>>()

        // Car Instance List 생성
        val cars = makeCarList(racingState.number!!.toInt())

        // 전진 시도
        repeat(racingState.attempt!!.toInt()) {
            move(cars)
            result.add(cars)
        }

        return result
    }

    fun makeCarList(number: Int): List<Car> {
        val cars = mutableListOf<Car>()
        (0 until number).forEach { i ->
            cars.add(Car(i))
        }
        return cars
    }

    fun move(carList: List<Car>) {
        carList.forEach { car ->
            if (canIMove()) {
                car.distance = car.distance + "-"
            }
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

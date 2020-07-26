package racing

import kotlin.random.Random

class RacingCar {

    companion object {
        const val MINIMUM_RANGE_NUMBER = 0
        const val MAXIMUN_RANGE_NUMBER = 9
        const val MOVE_CONDITION_NUMBER = 4
    }

    fun start(inputData: InputView): MutableList<List<Car>> {
        var result = mutableListOf<List<Car>>()
        var carList = mutableListOf<Car>()

        // Car Instance List 생성
        makeCarList(carList, inputData.number)

        // 전진 시도
        repeat(inputData.attempt) {
            move(carList)
            result.add(carList)
        }

        return result
    }

    fun makeCarList(carList: MutableList<Car>, number: Int) {
        // Car 객체 생성
        (0 until number).forEach { i ->
            carList.add(Car(i))
        }
    }

    fun move(carList: MutableList<Car>) {
        carList.forEach { car ->
            if (canIMove()) {
                car.distance = car.distance + "-"
            }
        }
    }

    fun canIMove(): Boolean {
        val random = Random.nextInt(MINIMUM_RANGE_NUMBER, MAXIMUN_RANGE_NUMBER)
        if (random >= MOVE_CONDITION_NUMBER) {
            return true
        }
        return false
    }
}

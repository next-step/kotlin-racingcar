package step3

import kotlin.random.Random

class RacingCar {

    fun start(inputData: InputView) {
        var carList = mutableListOf<Car>()

        // Car Instance List 생성
        makeCarList(carList, inputData.number)

        // 전진 시도
        repeat((0 until inputData.attempt).count()) {
            move(carList)
            ResultView().view(carList) // view
        }
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
        val random = Random.nextInt(0, 9)
        if (random > 3) {
            return true
        }
        return false
    }
}

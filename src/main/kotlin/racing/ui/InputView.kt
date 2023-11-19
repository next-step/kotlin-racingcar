package racing.ui

import racing.Car

object InputView {
    private const val MAX_CAR_NAME_LENGTH = 5
    fun getMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

    fun getCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readlnOrNull() ?: ""
        val carList = splitCars(input)
        if (validateCarNames(carList)) {
            return carList
        } else {
            return getCars()
        }
    }

    private fun validateCarNames(carList: List<Car>): Boolean {
        for (car in carList) {
            if (car.name.length > MAX_CAR_NAME_LENGTH) {
                println("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
                return false
            }
        }
        return true
    }

    private fun splitCars(cars: String): List<Car> {
        return cars.replace(" ", "").split(",").map { Car(it) }
    }
}

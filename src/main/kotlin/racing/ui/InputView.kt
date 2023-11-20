package racing.ui

import racing.domain.Car
import racing.domain.CarName

object InputView {
    private const val MAX_CAR_NAME_LENGTH = 5
    fun getMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

    fun getCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readlnOrNull() ?: ""
        return splitCars(input)
    }

    private fun splitCars(cars: String): List<Car> {
        return cars.replace(" ", "").split(",").map { Car(CarName(it)) }
    }
}

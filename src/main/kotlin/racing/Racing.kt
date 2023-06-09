package racing

import racing.domain.Car
import racing.view.InputView
import racing.view.ResultView
import java.util.Random

class Racing {

    fun run() {

        InputView.printInputCar()
        val n = readLine()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
        InputView.printInputCount()
        val count = readLine()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")

        ResultView.printResult()

        val cars = createCars(n)
        carRacing(count, cars)
    }

    fun createCars(n: Int): List<Car> = (1 until n + 1).map { Car() }

    fun carRacing(count: Int, cars: List<Car>) {
        repeat(count) {
            for (car in cars) {
                moveAndStop(car)
            }
            println()
        }
    }

    private fun moveAndStop(car: Car) {
        val moveFlag = Random().nextInt(10) >= 4
        if (moveFlag) {
            car.position = car.position?.plus(1)
            val distance = car.position?.let { "-".repeat(it) }
            println(distance)
            return
        }

        if (car.position == 0) {
            println()
        } else {
            val distance = car.position?.let { "-".repeat(it) }
            println(distance)
        }
    }
}

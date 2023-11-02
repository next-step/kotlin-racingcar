package racing.v2.console

import racing.v2.domain.Car

object ResultView {
    fun printCarPosition(cars: List<Car>) {
        println("실행 결과")
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}

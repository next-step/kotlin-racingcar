package racing.view

import racing.domain.Car
import racing.domain.Cars

object OutPutView {
    fun printStart() {
        println("\n실행 결과")
    }

    fun printRound(cars: Cars) {
        cars.cars.forEach { car -> println("${car.name} : ${makeBar(car.position)}") }
        println()
    }

    private fun makeBar(position: Int): String {
        var sb = StringBuilder()
        repeat(position) {
            sb.append("-")
        }
        return sb.toString()
    }

    fun printResult(cars: Cars) {
        val winners = cars.getWinners().joinToString(separator = ", ", transform = Car::name)
        println("${winners}가 우승했습니다.")
    }
}

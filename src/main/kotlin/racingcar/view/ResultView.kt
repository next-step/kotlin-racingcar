package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Race

class ResultView {
    fun printResultTitle() {
        println()
        print("실행 결과")
    }

    fun printWinner(race: Race, carsInfo: List<Car>) {
        println()
        val winners = race.findWinner(carsInfo).joinToString(",") { it.name }
        println("${winners}가 최종 우승했습니다.")
    }

    fun printCarsInfo(carsInfo: List<Car>) {
        println()
        carsInfo.forEach {
            printCarInfo(it.name)
            printRouteInfo(it.route)
        }
    }

    private fun printCarInfo(name: String) {
        print("$name:")
    }

    private fun printRouteInfo(route: Int) {
        println(makeRouteInfo(route))
    }

    private fun makeRouteInfo(route: Int) = buildString {
        repeat(route) { append("-") }
    }
}

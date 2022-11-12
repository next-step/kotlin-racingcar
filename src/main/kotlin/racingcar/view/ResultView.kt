package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Race

class ResultView {
    fun printRaceResult(race: Race, cars: List<Car>) {
        print("실행 결과")
        repeat(race.round) { printCarsInfo(race.run(cars)) }
    }

    private fun printCarsInfo(carsInfo: List<Car>) {
        println()
        carsInfo.forEach { printRouteInfo(it.route) }
    }

    private fun printRouteInfo(route: Int) {
        println(makeRouteInfo(route))
    }

    private fun makeRouteInfo(route: Int) = buildString {
        repeat(route) { append("-") }
    }
}

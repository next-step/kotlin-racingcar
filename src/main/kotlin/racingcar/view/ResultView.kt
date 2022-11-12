package racingcar.view

import racingcar.domain.Car

class ResultView {
    fun printResultTitle() {
        print("실행 결과")
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

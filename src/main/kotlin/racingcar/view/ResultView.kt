package racingcar.view

import racingcar.domain.Car

class ResultView {

    fun printResultTitle() {
        println()
        print("실행 결과")
    }

    fun printWinner(winnersName: List<String>) {
        println()
        println("${winnersName.joinToString(",")}가 최종 우승했습니다.")
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

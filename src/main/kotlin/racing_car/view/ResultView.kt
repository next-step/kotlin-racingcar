package racing_car.view

import racing_car.domain.CarInfo

object ResultView {

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printPosition(carInfos: List<CarInfo>) {
        carInfos.forEach {
            val name = it.name
            val positionBar = "-".repeat(it.position)
            println("$name : $positionBar")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        val namesOfWinners = winners.joinToString()
        println("$namesOfWinners (이)가 최종 우승했습니다.")
    }
}

package racing.view

import racing.domain.CarInfo

object ResultView {

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printResult(carInfos: List<CarInfo>) {
        carInfos.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }

    fun printWinner(winnerCarInfos: List<CarInfo>) {
        val winners: String = winnerCarInfos.map(CarInfo::name).joinToString(separator = ",")
        println("${winners}가 최종 우승했습니다.")
    }
}

package racing.ui

import racing.car.Cars

typealias ResultViewAction = (Cars) -> Unit
class ResultView {
    fun makeResultView(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.position)
            println("${car.name} : $positionGraph")
        }
        println()
    }

    fun makeResultViewWithName(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.position)
            println("${car.name} : $positionGraph")
        }
        println()
    }

    fun makeWinnerView(cars: Cars) {
        val winner = cars.getWinner()
            .joinToString(",") { it -> it.name }
        println("$winner 가 최종 우승했습니다.")
    }
}

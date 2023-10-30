package racing.ui

import racing.Cars

class ResultView {
    fun makeResultView(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.currentPosition)
            println("${car.name} : $positionGraph")
        }
        println()
    }

    fun makeResultViewWithName(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.currentPosition)
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

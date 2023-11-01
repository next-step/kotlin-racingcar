package racing.ui

import racing.car.Cars

typealias ResultViewAction = (Cars) -> Unit
class ResultView {
    fun resultViewWithoutName(carsList: MutableList<Cars>) {
        carsList.forEach { cars ->
            makeResultView(cars)
        }
    }

    private fun makeResultView(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.position)
            println("${car.name} : $positionGraph")
        }
        println()
    }

    fun resultViewWithWinner(carsList: MutableList<Cars>) {
        resultViewWithName(carsList)
        makeWinnerView(carsList.last())
    }

    private fun resultViewWithName(carsList: MutableList<Cars>) {
        carsList.forEach { cars ->
            makeResultViewWithName(cars)
        }
    }

    private fun makeResultViewWithName(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.position)
            println("${car.name} : $positionGraph")
        }
        println()
    }

    private fun makeWinnerView(cars: Cars) {
        val winner = cars.getWinner()
            .joinToString(",") { it -> it.name }
        println("$winner 가 최종 우승했습니다.")
    }
}

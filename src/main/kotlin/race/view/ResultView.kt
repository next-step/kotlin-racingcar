package race.view

import race.model.Car

class ResultView {
    fun run(raceResult: RaceResult) {
        val records = raceResult.records

        println("실행 결과")
        records.forEach {
            showAllPosition(it)
        }

        showWinners(raceResult.winners)
    }

    private fun showAllPosition(cars: List<Car>) {
        cars.forEach { show(it) }
        println()
    }

    private fun show(car: Car) {
        println("${car.name} : " + "-".repeat(car.position))
    }

    private fun showWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}

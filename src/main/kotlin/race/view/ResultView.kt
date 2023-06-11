package race.view

import race.model.CarRecord

class ResultView {
    fun run(raceResult: RaceResult) {
        val records = raceResult.records

        println("실행 결과")
        records.forEach {
            showAllPosition(it)
        }

        showWinners(raceResult.winners)
    }

    private fun showAllPosition(cars: List<CarRecord>) {
        cars.forEach {
            show(it)
        }
        println()
    }

    private fun show(car: CarRecord) {
        println("${car.name} : " + "-".repeat(car.position))
    }

    private fun showWinners(winners: List<CarRecord>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}

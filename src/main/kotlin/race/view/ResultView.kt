package race.view

import race.model.CarRecord

class ResultView {
    fun run(raceResult: RaceResult) {
        val records = raceResult.records

        println("실행 결과")
        records.forEach {
            showAllPosition(it)
        }

        showWinners(records.last())
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

    private fun findWinnerNames(lastRecords: List<CarRecord>): String {
        val sorted = lastRecords.sorted()
        val winnerPosition = sorted.last().position

        return sorted
            .filter { it.position == winnerPosition }
            .joinToString(", ") { it.name }
    }

    private fun showWinners(lastRecords: List<CarRecord>) {
        val winnerNames = findWinnerNames(lastRecords)
        println("${winnerNames}가 최종 우승했습니다.")
    }
}

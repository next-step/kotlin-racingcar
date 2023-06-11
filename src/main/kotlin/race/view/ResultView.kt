package race.view

import race.CarRecord

class ResultView {
    fun run(raceResult: RaceResult) {
        val records = raceResult.records

        println("실행 결과")
        records.forEach {
            showAllPosition(it)
        }
    }

    private fun showAllPosition(cars: List<CarRecord>) {
        cars.forEach {
            show(it)
        }
        println()
    }

    private fun show(car: CarRecord) {
        println("-".repeat(car.position))
    }
}

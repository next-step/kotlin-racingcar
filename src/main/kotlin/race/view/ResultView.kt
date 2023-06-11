package race.view

import race.CarRecord

class ResultView {
    fun run(resultData: ResultData) {
        val records = resultData.records

        println("실행 결과")
        for (record in records) {
            showAllPosition(record)
        }
    }

    private fun showAllPosition(cars: List<CarRecord>) {
        for (car in cars) {
            show(car)
        }
        println()
    }

    private fun show(car: CarRecord) {
        println("-".repeat(car.position))
    }
}

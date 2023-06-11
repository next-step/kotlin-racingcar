package race.view

import race.Car

class ResultView {
    fun run(resultData: ResultData) {
        val records = resultData.records

        println("실행 결과")
        for (record in records) {
            showAllPosition(record)
        }
    }

    private fun showAllPosition(cars: List<Car>) {
        for (car in cars) {
            show(car)
        }
        println()
    }

    private fun show(car: Car) {
        repeat(car.position) {
            print('-')
        }
        println()
    }
}

package racingCar

object OutputView {
    fun showResultMessage() {
        println("실행 결과")
    }

    fun showResult(cars: Cars) {
        cars.cars.forEach {
            printCarDistance(it.distance)
            println()
        }
        println()
    }

    private fun printCarDistance(distance: Int) {
        repeat(distance) {
            print("-")
        }
    }
}

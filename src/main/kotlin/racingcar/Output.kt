package racingcar

class Output {

    fun showStartMessage() {
        println("----------------------------------")
        println("실행결과")
    }

    fun showResultPosition(cars: Cars) {
        cars.cars.forEach {
            showGauge(it.position)
        }
        println()
    }

    private fun showGauge(position: Int) {
        repeat(position) {
            print("-")
        }
        println()
    }
}
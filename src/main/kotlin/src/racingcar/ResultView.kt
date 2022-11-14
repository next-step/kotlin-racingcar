package src.racingcar

object ResultView {
    fun showGameResult(cars: MutableList<Car>) {
        printRacingCarGameResult(cars)
    }

    private fun printRacingCarGameResult(cars: MutableList<Car>) {
        for (i in 0 until cars.first().getMoveCountSize()) {
            for (car in cars) {
                println("-".repeat(car.getMoveCountIndex(i) + 1))
            }
            println()
        }
    }
}

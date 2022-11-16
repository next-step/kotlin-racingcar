package src.racingcar

class CarService {

    fun execute(tryCount: Int, carCount: Int) {
        (1..tryCount).forEach { _ ->
            moveCars(carCount)
        }
    }

    private fun moveCars(carCount: Int) {
        (1..carCount).forEach { _ ->
            ResultView.printRacingCarGameResult(Car().move())
        }
        println()
    }
}
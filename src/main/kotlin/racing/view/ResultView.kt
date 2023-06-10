package racing.view

import racing.car.RacingCar

class ResultView {
    private val RACING_MARK = '-'
    fun showGameBoard(racingCars: List<RacingCar>) {
        racingCars.forEach {
            show(it)
        }
        println()
    }

    fun show(racingCar: RacingCar) {
        repeat(racingCar.position) {
            print(RACING_MARK)
        }
        println()
    }
}

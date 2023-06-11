package racingcar.domain

import racingcar.view.OutputView

class Round() {

    private val outputView: OutputView = OutputView()

    fun execute(cars: ArrayList<Car>) {
        for (car in cars) {
            car.isMoveOrStop()
        }
        outputView.printRound(cars)
    }
}

package presentation.view

import domain.Race

class ResultView {

    fun result() {
        val race = Race()
        val inputView = InputView()
        inputView.inputCarCount()
        inputView.inputRetryRetryCount()
        if (inputView.getRetryCount() == 0 || inputView.getCarList().isEmpty()) throw Exception("retryCount() == 0 || carList.isEmpty()")
        repeat(inputView.getRetryCount()) {
            inputView.getCarList().map { car ->
                println("-".repeat(race.carRace(car, car.isMoving())))
            }
            println()
        }
    }
}

package presentation

import domain.CarRace

class ResultView {

    private val inputView = InputView()
    private val carRace = CarRace()

    fun executeCarRace() {
        val carCount = inputView.inputData()
        val retryCount = inputView.inputData()
        var num = retryCount

        carRace.initCarMovementCountList(carCount = carCount)

        while (num > 0) {
            for (i in 0 until carCount) {
                println("-".repeat(carRace.moveCar(i)))
            }
            println()
            num--
        }
    }
}

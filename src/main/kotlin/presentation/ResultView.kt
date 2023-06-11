package step3.presentation

import step3.domain.MoveCarUseCase

class ResultView {

    private val inputView = InputView()
    private val moveCarUseCase = MoveCarUseCase()

    fun executeCarRace() {
        val carCount = inputView.inputData()
        val retryCount = inputView.inputData()
        var num = retryCount

        moveCarUseCase.initCarMovementCountList(carCount = carCount)

        while (num > 0) {
            for (i in 0 until carCount) {
                println("-".repeat(moveCarUseCase.moveCar(i)))
            }
            println()
            num--
        }
    }
}

package racingcar.view.output

import racingcar.model.Car
import racingcar.model.CarRecord
import racingcar.model.RacingGame
import racingcar.model.RacingRecord

class WinnerResultView : ResultView {

    override fun showResultView(racingGame: RacingGame) {
        if (racingGame.currentStep == 1) {
            println(MESSAGE_FOR_START_GAME)
        }
        racingGame.carList.forEach { println(it.toDisplayString()) }
        println()

        if (racingGame.isOver) {
            println(MESSAGE_FOR_END_OF_GAME)
        }
    }

    override fun showResultView(racingRecord: RacingRecord) {
        val steps = racingRecord.stepToTry
        println(MESSAGE_FOR_START_GAME)
        repeat(steps) { step ->
            printRacingRecordForTheStepAt(racingRecord, step)
        }
        printWinner(racingRecord.winnersRecord)
        println(MESSAGE_FOR_END_OF_GAME)
    }

    private fun printRacingRecordForTheStepAt(racingRecord: RacingRecord, step: Int) {
        racingRecord.carRecordList.forEach { recordForACar ->
            println(recordForACar.toDisplayString(step))
        }
        println()
    }

    private fun printWinner(winnersRecord: List<CarRecord>) {
        val winnersName = winnersRecord.joinToString(", ") { it.car.carName }
        println("${winnersName}가 최종 우승했습니다.")
    }

    private fun CarRecord.toDisplayString(step: Int) = "${this.car.carName}: ${this.recordForStep[step].toBarString()}"
    private fun Car.toDisplayString() = "${this.carName}: ${this.position.toBarString()}}"
    private fun Int.toBarString() = "-".repeat(this + 1)

    companion object {
        private const val MESSAGE_FOR_START_GAME = "실행 결과"
        private const val MESSAGE_FOR_END_OF_GAME = "Game Over"
    }
}

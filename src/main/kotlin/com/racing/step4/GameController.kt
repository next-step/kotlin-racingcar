package com.racing.step4

import com.racing.step4.domain.RacingParticipation
import com.racing.step4.view.InputView
import com.racing.step4.view.OutputView
import kotlin.random.Random

object GameController {
    fun exec() {
        val participation = createParticipation()
        val stageNumber = getStageNumber()

        race(
            participation = participation,
            repeat = stageNumber,
            execAfterStage = { cars -> showCarNameWithPosition(cars) }
        )

        notifyWinner(participation)
    }

    private fun createParticipation(): RacingParticipation {
        val readCarNames = InputView.readCarNames()
        return RacingParticipation(readCarNames)
    }

    private fun getStageNumber(): Int {
        return InputView.readStageNumber()
    }

    private fun race(
        participation: RacingParticipation,
        repeat: Int,
        execAfterStage: (RacingParticipation) -> Unit
    ) {
        repeat(repeat) {
            participation.turnAround(moveTrigger())
            execAfterStage(participation)
        }
    }

    private fun showCarNameWithPosition(participation: RacingParticipation) {
        OutputView.showRacingResultDashboard(participation.cars.associate { it.name to it.position })
    }

    private fun notifyWinner(participation: RacingParticipation) {
        val winner = participation.findWinner()
        OutputView.showWinner(winner.joinToString(",") { it.name })
    }

    private fun moveTrigger(): () -> Int = { Random.nextInt(10) }
}

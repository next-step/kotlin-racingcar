package com.racing.step4

import com.racing.step4.domain.RacingParticipation
import com.racing.step4.view.InputView
import com.racing.step4.view.OutputView
import kotlin.random.Random

object GameController {
    fun exec() {
        val participation = setParticipation()
        gameStart(participation)
        notifyWinner(participation)
    }

    private fun setParticipation(): RacingParticipation {
        val readCarNames = InputView.readCarNames()
        return RacingParticipation(readCarNames)
    }

    private fun gameStart(participation: RacingParticipation) {
        val stageNum = InputView.readStageNumber()
        OutputView.showStartMessage()
        repeat(stageNum) {
            participation.turnAround(moveTrigger())
            OutputView.showRacingResultDashboard(participation.cars.associate { it.name to it.position })
        }
    }

    private fun notifyWinner(participation: RacingParticipation) {
        val winner = participation.findWinner()
        OutputView.showWinner(winner.joinToString(",") { it.name })
    }

    private fun moveTrigger(): () -> Int = { Random.nextInt(10) }
}

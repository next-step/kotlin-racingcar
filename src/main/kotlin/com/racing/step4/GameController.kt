package com.racing.step4

import com.racing.step4.domain.RacingParticipation
import com.racing.step4.view.InputView
import com.racing.step4.view.OutputView
import kotlin.random.Random

object GameController {
    fun exec() {
        val readCarNames = InputView.readCarNames()
        val stageNum = InputView.readStageNumber()
        val racingParticipation = RacingParticipation(readCarNames)

        OutputView.showStartMessage()
        repeat(stageNum) {
            racingParticipation.turnAround { Random.nextInt(10) }
            OutputView.showRacingResultDashboard(racingParticipation.cars.associate { it.name to it.position })
        }
        val winner = racingParticipation.findWinner()
        OutputView.showWinner(winner.joinToString(",") { it.name })
    }
}

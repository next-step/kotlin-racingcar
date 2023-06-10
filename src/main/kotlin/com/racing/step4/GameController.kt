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
        val carStageSnapshot = mutableListOf<String>()

        repeat(stageNum) {
            racingParticipation.turnAround { Random.nextInt(10) }
            carStageSnapshot.add(racingParticipation.toString())
        }
        val winner = racingParticipation.findWinner()

        OutputView.showRacingResultDashboard(carStageSnapshot)
        OutputView.showWinner(winner.map { it.name }.joinToString(","))
    }
}

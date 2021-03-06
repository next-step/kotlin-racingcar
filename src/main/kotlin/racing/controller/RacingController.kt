/*
 * Copyright (c) 2021. LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package racing.controller

import racing.domain.MovementChecker
import racing.domain.RacingGame
import racing.ui.InputView
import racing.ui.ResultView

/**
 * @author tae-heon.song<taeheon.song@linecorp.com>
 * @since 2021. 03. 06.
 */
object RacingController {
    fun run() {
        val racingGameData = InputView.askQuestion()
        val racingGame = RacingGame(racingGameData, MovementChecker())

        ResultView.printResultNotice()

        racingGame.run()

        ResultView.printRacingHistory(racingGame.racingHistory)
        ResultView.printWinners(racingGame.getWinners())
    }
}
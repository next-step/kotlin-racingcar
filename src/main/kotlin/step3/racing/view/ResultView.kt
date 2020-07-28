package step3.racing.view

import step3.racing.result.RacingResult
import step3.racing.winner.WinnerChecker

class ResultView(
    private val result: RacingResult
) : ConsoleView() {
    private val winnerChecker = WinnerChecker()
    override fun renderView() {
        // 시상식
        winnerChecker.rewardWinner(result.cars, this)
    }
}

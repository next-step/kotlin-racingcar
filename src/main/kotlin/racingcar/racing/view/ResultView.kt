package racingcar.racing.view

import racingcar.racing.printer.CarNamePrinter
import racingcar.racing.printer.CarPrinter
import racingcar.racing.printer.ResultPrinter
import racingcar.racing.result.RacingResult
import racingcar.racing.winner.WinnerChecker

class ResultView(
    private val results: List<RacingResult>
) : ConsoleView() {
    private val printer: CarPrinter = CarNamePrinter(this)
    private val winnerChecker = WinnerChecker()
    override fun renderView() {
        // 레이싱 결과 출력
        ResultPrinter(printer, results, this).print()
        // 시상식
        val winners = winnerChecker.findWinners(results.last().cars)
        winnerChecker.rewardWinner(winners, this)
    }
}

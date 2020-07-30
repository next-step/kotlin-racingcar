package step3.racing.view

import step3.racing.printer.CarNamePrinter
import step3.racing.printer.CarPrinter
import step3.racing.printer.ResultPrinter
import step3.racing.result.RacingResult
import step3.racing.winner.WinnerChecker

class ResultView(
    private val result: RacingResult
) : ConsoleView() {
    private val printer: CarPrinter = CarNamePrinter(this)
    private val winnerChecker = WinnerChecker()
    override fun renderView() {
        // 레이싱 결과 출력
        ResultPrinter(printer, result.turns, this).print()
        // 시상식
        winnerChecker.rewardWinner(result.turns.last().cars, this)
    }
}

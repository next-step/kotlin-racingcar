package racingcar.racing.view

import racingcar.racing.printer.CarNamePrinter
import racingcar.racing.printer.CarPrinter
import racingcar.racing.printer.ResultPrinter
import racingcar.racing.result.RacingResult
import racingcar.racing.winner.WinnerChecker

class ResultView(
    private val result: RacingResult
) : ConsoleView() {
    private val printer: CarPrinter = CarNamePrinter(this)
    private val winnerChecker = WinnerChecker()
    override fun renderView() {
        // 레이싱 결과 출력
        ResultPrinter(printer, result.turns, this).print()
        // 시상식
        winnerChecker.rewardWinner(result.winners, this)
    }
}

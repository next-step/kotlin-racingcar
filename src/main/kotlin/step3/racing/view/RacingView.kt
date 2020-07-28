package step3.racing.view

import step3.racing.RacingCarGame
import step3.racing.car.Car
import step3.racing.printer.CarPrinter
import step3.racing.printer.CarPrinterImpl
import step3.racing.result.RacingResult
import step3.racing.rule.CarMovementRule
import step3.racing.rule.CarMovementRuleImpl
import step3.turn.Turn
import step3.turn.TurnImpl
import step3.turn.TurnManager
import step3.turn.TurnManagerImpl

class RacingView(
    private val cars: List<Car>,
    private val turns: Int
) : ConsoleView() {
    private val printer: CarPrinter = CarPrinterImpl(this)
    private val rule: CarMovementRule = CarMovementRuleImpl()

    override fun renderView() {
        val turn: Turn = TurnImpl.create(cars, rule, printer)
        val turnManager: TurnManager = TurnManagerImpl(turns, turn)
        // 게임 시작
        val result = RacingCarGame(this, turnManager).startRacing(cars)

        // 경기 결과로 이동
        navigateToResult(result)
    }

    private fun navigateToResult(result: RacingResult) {
        ResultView(result).renderView()
    }
}

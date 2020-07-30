package step3.racing.view

import step3.racing.RacingCarGame
import step3.racing.car.Car
import step3.racing.result.RacingResult
import step3.racing.rule.CarMovementRule
import step3.racing.rule.CarRandomMovementRule
import step3.turn.Turn
import step3.turn.TurnManager
import step3.turn.SimpleTurnManager

class RacingView(
    private val cars: List<Car>,
    private val turns: Int
) : ConsoleView() {
    private val rule: CarMovementRule = CarRandomMovementRule()

    override fun renderView() {
        val turn = Turn(cars = cars, rule = rule)
        val turnManager: TurnManager = SimpleTurnManager(turns, turn)
        // 게임 시작
        val result = RacingCarGame(turnManager).startRacing()

        // 경기 결과로 이동
        navigateToResult(result)
    }

    private fun navigateToResult(result: RacingResult) {
        ResultView(result).renderView()
    }
}

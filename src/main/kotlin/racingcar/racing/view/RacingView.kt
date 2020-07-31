package racingcar.racing.view

import racingcar.racing.RacingCarGame
import racingcar.racing.car.Car
import racingcar.racing.result.RacingResult
import racingcar.racing.rule.CarMovementRule
import racingcar.racing.rule.CarRandomMovementRule
import racingcar.turn.Turn
import racingcar.turn.TurnManager
import racingcar.turn.SimpleTurnManager

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

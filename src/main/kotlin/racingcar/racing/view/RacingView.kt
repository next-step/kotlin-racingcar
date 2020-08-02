package racingcar.racing.view

import racingcar.racing.car.Car
import racingcar.racing.result.RacingResult
import racingcar.racing.rule.CarMovementRule
import racingcar.racing.rule.CarRandomMovementRule
import racingcar.turn.SimpleTurnManager
import racingcar.turn.TurnManager

class RacingView(
    private val cars: List<Car>,
    private val turns: Int
) : ConsoleView() {
    private val rule: CarMovementRule = CarRandomMovementRule()

    override fun renderView() {
        val turnManager: TurnManager = SimpleTurnManager(turns, cars, rule)
        // 게임 시작
        val result = turnManager.startRaceUntilFinish()

        // 경기 결과로 이동
        navigateToResult(result)
    }

    private fun navigateToResult(result: List<RacingResult>) {
        navigateTo(ResultView(result))
    }
}

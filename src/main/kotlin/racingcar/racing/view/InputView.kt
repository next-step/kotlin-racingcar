package racingcar.racing.view

import racingcar.racing.GameSetupHelper
import racingcar.racing.car.Car
import racingcar.racing.const.HOW_MANY_CAR
import racingcar.racing.const.HOW_MANY_TURN

class InputView(val setup: GameSetupHelper) : ConsoleView() {
    override fun renderView() {
        // 게임 조건 입력
        val cars: List<Car> = setup.askHowManyCars(input(HOW_MANY_CAR))
        val turns = setup.askHowManyTurns(input(HOW_MANY_TURN))

        // 경기 시작
        navigateToRaceView(cars, turns)
    }

    private fun navigateToRaceView(cars: List<Car>, turns: Int) {
        navigateTo(
            RacingView(cars, turns)
        )
    }
}

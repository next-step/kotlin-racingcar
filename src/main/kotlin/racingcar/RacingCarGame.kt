package racingcar

import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.GameCount
import racingcar.model.RacingCarGameResult
import racingcar.view.InputView
import racingcar.view.OutputView

/**
 * 자동차 경주에 대한 개념
 *
 * [RacingCarGame]의 행동 (method)
 * 1. 게임을 시작한다.
 *
 * 협력 관계 (communication)
 * 1. 게임을 진행하기 위한 자동차를 준비한다. (InputView)
 * 2. 몇 번의 게임을 진행할지 호스트로부터 받아서 게임을 준비한다. (InputView)
 * 3. 자동차를 호스트로부터 건네받아 게임을 준비한다. (RacingCarsFactory)
 * 4. 게임 진행상황에 대해 어떻게 그릴지 요청한다. (OutputView)
 */
class RacingCarGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingCarsFactory: RacingCarsFactory
) {

    fun startGame() {
        val carNames: List<CarName> = inputView.getCarNames()
        val gameCount: GameCount = inputView.getGameCount()

        val cars = racingCarsFactory.createCars(carNames)
        startGame(gameCount, cars)
    }

    private fun startGame(gameCount: GameCount, cars: Cars) {
        outputView.showGameStart()

        repeat(gameCount.count) { round -> race(round + 1, cars) }

        val gameResult = RacingCarGameResult(gameCount = gameCount, cars = cars)
        outputView.showGameResult(gameResult)
    }

    private fun race(round: Int, cars: Cars) {
        outputView.showGameRoundStart(round, cars)
        cars.move()
        outputView.showGameRoundEnd(round, cars)
    }
}

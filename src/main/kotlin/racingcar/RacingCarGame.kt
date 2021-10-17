package racingcar

import racingcar.model.CarCount
import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.GameCount
import racingcar.model.RacingCarGameResult
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
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
        val carCount: CarCount = inputView.getCarCount()
        val gameCount: GameCount = inputView.getGameCount()

        // TODO: Input View로부터 CarNames 입력받기
        val cars = racingCarsFactory.createCars(List(carCount.count) { CarName("${it + 1}") })
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

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val racingCarForwardCondition = RacingCarForwardCondition { (0..9).random() >= 4 }
            val racingCarsFactory = RacingCarsFactory { carNames -> Cars(carNames, racingCarForwardCondition) }
            val racingCarGame = RacingCarGame(
                inputView = ConsoleInputView(),
                outputView = ConsoleOutputView("\uD83D\uDE97"),
                racingCarsFactory = racingCarsFactory,
            )
            racingCarGame.startGame()
        }
    }
}

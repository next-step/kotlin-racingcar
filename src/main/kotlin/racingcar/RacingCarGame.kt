package racingcar

import racingcar.model.CarCount
import racingcar.model.Cars
import racingcar.model.GameCount
import racingcar.model.RacingCarGameResult
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
import racingcar.view.InputView
import racingcar.view.OutputView

/**
 * 게임에 대한 시작과 끝. 진행 상황 등을 알 수 있는 객체
 *
 * [RacingCarGame]의 행동 (method)
 * 1. 게임을 시작한다.
 *
 * 협력 관계 (communication)
 * 1. 게임을 진행하기 위한 자동차를 준비한다. (InputView)
 * 2. 몇 번의 게임을 진행할지 호스트로부터 받아서 게임을 준비한다. (InputView)
 * 3. 자동차가 전진 혹은 후진하기 위한 방법을 제시한다. (RacingCarForwardCondition)
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

        val cars = racingCarsFactory.createCars(carCount)
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
            val racingCarsFactory = RacingCarsFactory { carCount -> Cars(carCount, racingCarForwardCondition) }
            val racingCarGame = RacingCarGame(
                inputView = ConsoleInputView(),
                outputView = ConsoleOutputView("\uD83D\uDE97"),
                racingCarsFactory = racingCarsFactory,
            )
            racingCarGame.startGame()
        }
    }
}

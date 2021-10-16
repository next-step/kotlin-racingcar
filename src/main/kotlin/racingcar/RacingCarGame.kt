package racingcar

import racingcar.model.Car
import racingcar.model.CarCount
import racingcar.model.GameCount
import racingcar.model.RacingCarGameResult
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleResultView
import racingcar.view.InputView
import racingcar.view.ResultView

/**
 * 게임에 대한 시작과 끝. 진행 상황 등을 알 수 있는 객체
 *
 * [RacingCarGame]의 행동 (method)
 * 1. 게임을 시작한다.
 *
 * 협력 관계 (communication)
 * 1. 게임을 진행하기 위한 자동차를 준비한다. (InputView)
 * 2. 몇 번의 게임을 진행할지 호스트로부터 받아서 게임을 준비한다. (InputView)
 * 3. 자동차가 전진 혹은 후진하기 위한 방법을 제시한다. (RacingCarMoveMethod)
 * 4. 게임 진행상황에 대해 어떻게 그릴지 요청한다. (ResultView)
 */
class RacingCarGame(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val racingCarMoveMethod: RacingCarMoveMethod
) {

    fun startGame() {
        val carCount: CarCount = inputView.getCarCount()
        checkCarCount(carCount)

        val gameCount: GameCount = inputView.getGameCount()
        checkGameCount(gameCount)

        startGame(carCount, gameCount)
    }

    private fun startGame(carCount: CarCount, gameCount: GameCount) {
        resultView.showGameStart()
        var cars: List<Car> = List(carCount.count) { Car() }

        repeat(gameCount.count) { round ->
            resultView.showGameRoundStart(round + 1, cars)
            cars = cars.map { car -> car.tryMove(racingCarMoveMethod) }
            resultView.showGameRoundEnd(round + 1, cars)
        }

        val gameResult = RacingCarGameResult(
            carCount = carCount,
            gameCount = gameCount,
            cars = cars
        )
        resultView.showGameResult(gameResult)
    }

    private fun Car.tryMove(method: RacingCarMoveMethod): Car =
        if (method.isForward()) {
            forward()
        } else {
            backward()
        }

    private fun checkCarCount(carCount: CarCount) {
        val count = carCount.count
        require(count > 0) {
            "게임을 진행하기 위한 자동차 대수는 최소 1대 이상이 필요합니다. 입력값: $count"
        }
    }

    private fun checkGameCount(gameCount: GameCount) {
        val count = gameCount.count
        require(count > 0) {
            "게임을 진행하기 위한 시도 횟수는 최소 1회 이상이 필요합니다. 입력값: $count"
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val racingCarMoveMethod = { (0..9).random() >= 4 }
            val racingCarGame = RacingCarGame(
                inputView = ConsoleInputView(),
                resultView = ConsoleResultView(),
                racingCarMoveMethod = racingCarMoveMethod
            )
            racingCarGame.startGame()
        }
    }
}

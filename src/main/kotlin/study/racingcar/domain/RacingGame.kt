package study.racingcar.domain

import study.racingcar.application.CarNames
import study.racingcar.view.InputValue
import study.racingcar.view.InputView
import study.racingcar.view.OutputView

/**
 * view 를 통해 입력받은 데이터를 가지고 게임을 진행한다.
 * */
class RacingGame(
    private val inputView: InputView,
    private val gameRule: GameRule
) {

    fun run() {
        // 0. inputView 에게 메시지 (input 수행 요청) 던진다.
        val input: InputValue = inputView.getInput()
        val carNames: CarNames = input.carNames
        val tryCount: Int = input.tryCount

        // 1. carNames 에게 메시지 (RacingCars 를 생성 요청) 던진다.
        val racingCars = carNames.prepareForRace()

        // 2. racingCars 에게 메시지 (game 수행 요청) 던진다.
        racingCars.playGame(tryCount, gameRule)

        // 3. outputView 에게 메시지 (우승자 출력 요청) 던진다.
        OutputView.showWinners(racingCars)
    }
}

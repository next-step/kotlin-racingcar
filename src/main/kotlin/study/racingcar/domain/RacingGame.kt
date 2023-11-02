package study.racingcar.domain

import study.racingcar.application.CarNames
import study.racingcar.application.InputValue
import study.racingcar.application.InputView
import study.racingcar.application.OutputView

/**
 * view 를 통해 입력받은 데이터를 가지고 게임을 진행한다.
 * */
class RacingGame(
    private val inputView: InputView,
) {

    private val input: InputValue = inputView.getInput()
    private val carNames: CarNames = input.carNames
    private val tryCount: Int = input.tryCount

    fun run() {
        val gameRule =
            FourOrMoreGameRule() // TODO-review : 테스트 하기 어려운 객체를 객체 그래프의 최상단으로 끌어올렸습니다. (racingCar 에게 gamerule 을 주입하는 형태로 테스트를 하기 위해.)

        // 1. carNames 에게 메시지 (RacingCars 를 생성 요청) 던진다.
        val racingCars = carNames.prepareForRace()

        // 2. racingCars 에게 메시지 (game 수행 요청) 던진다.
        racingCars.playGame(tryCount, gameRule)

        // 3. outputView 에게 메시지 (우승자 출력 요청) 던진다.
        OutputView.showWinners(racingCars)
    }
}

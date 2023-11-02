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
) {

    // TODO-review: RacingGame 이 만들어짐과 동시에 프로퍼티로 생성되는 멤버들입니다.
    private val input: InputValue = inputView.getInput()
    private val carNames: CarNames = input.carNames
    private val tryCount: Int = input.tryCount

    fun run() {
        // TODO-review : 테스트 하기 어려운 객체를 객체 그래프의 최상단으로 끌어올렸습니다.
        //  (racingCar 에게 gamerule 을 주입하는 형태로 테스트를 하기 위해.)
        val gameRule = FourOrMoreGameRule()

        // 1. carNames 에게 메시지 (RacingCars 를 생성 요청) 던진다.
        val racingCars = carNames.prepareForRace()

        // 2. racingCars 에게 메시지 (game 수행 요청) 던진다.
        racingCars.playGame(tryCount, gameRule)

        // 3. outputView 에게 메시지 (우승자 출력 요청) 던진다.
        OutputView.showWinners(racingCars)
    }
}

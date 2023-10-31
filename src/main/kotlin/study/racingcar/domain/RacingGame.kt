package study.racingcar.domain

import study.racingcar.application.InputView
import study.racingcar.application.OutputView

/**
 * view 를 통해 입력받은 데이터를 가지고 게임을 진행한다.
 * */
class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    // TODO-review : RacingGaem 에서 run 을 많은 일을 수행하는 것으로 보이지만,
    // InputView / RacingCar / OutputView 에게 메시지를 던져서 오케스트레이션 하는 것으로 설계를 했습니다.
    // 적합한 설계인지 코멘트 부탁드립니다!
    fun run() {
        val input = inputView.getInput()
        val carNames = input.carNames
        val tryCount = input.tryCount

        val gameRule = FourOrMoreGameRule()

        // carTotalNum 만큼 RacingCar 를 생성하고, 초기 포지션 설정 후, 자료구조에 넣어 둔다.
        val racingCars: List<RacingCar> = carNames.map { name ->
            RacingCar(name, 1)
        }

        // tryCount 만큼 게임을 수행한다.
        (1..tryCount).map { _ ->
            racingCars.forEach { racingCar ->
                racingCar.moveForward(gameRule)
            }

            outputView.showResult(racingCars)
        }

        // 최종 결과 출력
        outputView.showWinners(racingCars)
    }
}

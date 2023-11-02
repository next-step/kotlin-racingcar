package study.racingcar.domain

import study.racingcar.application.CarName
import study.racingcar.application.InputValue
import study.racingcar.application.InputView
import study.racingcar.application.OutputView

/**
 * view 를 통해 입력받은 데이터를 가지고 게임을 진행한다.
 * */
class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val input: InputValue = inputView.getInput()
    private val carNames: List<CarName> = input.carNames
    private val tryCount: Int = input.tryCount

    fun run() {
        val gameRule = FourOrMoreGameRule()

        // carTotalNum 만큼 RacingCar 를 생성하고, 초기 포지션 설정 후, 자료구조에 넣어 둔다.
        val racingCars: List<RacingCar> = carNames.map { carName ->
            RacingCar(carName)
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

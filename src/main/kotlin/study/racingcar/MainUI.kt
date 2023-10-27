package study.racingcar

import study.racingcar.application.InputView.getInput
import study.racingcar.application.ResultView.showResult
import study.racingcar.domain.FourOrMoreGameRule
import study.racingcar.domain.Game
import study.racingcar.domain.RacingCar

/**
 * 사용자는 몇 대의 자동차로 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
 *     - 사용할 자동차 n 대
 *     - 전체 자동차에 대해 시도할 횟수 m 회
 * */
class MainUI

fun main(args: Array<String>) {
    val input = getInput()
    val carTotalNum = input.carTotalNum
    val tryCount = input.tryCount

    val gameRule = FourOrMoreGameRule()
    val game = Game(gameRule)

    // carTotalNum 만큼 RacingCar 를 생성하고, 초기 포지션 설정 후, 자료구조에 넣어 둔다.
    val racingCars: List<RacingCar> = List(carTotalNum) { index ->
        RacingCar((index + 100).toString(), 1)
    }

    // tryCount 만큼 게임을 수행한다.
    (1..tryCount).map { 회차 ->
        racingCars.forEach { x ->
            when (game.play()) {
                true -> x.moveForward()
                false -> x.moveBackward()
            }
        }

        println("$회차 회차")
        showResult(racingCars)
    }
}

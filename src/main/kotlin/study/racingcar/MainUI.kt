package study.racingcar

import study.racingcar.application.StdinReader
import study.racingcar.domain.FourOrMoreGameRule
import study.racingcar.domain.RacingGame
import study.racingcar.view.InputView

/**
 * entrance point
 * */
class MainUI

fun main() {
    // RacingGame 을 테스트 하기 위해 gameRule 과 inputView 를 객체 그래프의 최상단으로 올렸습니다.
    val inputView = InputView(StdinReader())
    val gameRule = FourOrMoreGameRule()

    val racingGame = RacingGame(inputView, gameRule)
    racingGame.run()
}

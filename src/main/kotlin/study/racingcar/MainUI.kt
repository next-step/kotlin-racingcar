package study.racingcar

import study.racingcar.view.InputView
import study.racingcar.application.StdinReader
import study.racingcar.domain.RacingGame

/**
 * entrance point
 * */
class MainUI

fun main() {
    val racingGame = RacingGame(InputView(StdinReader())) // 테스트 하기 어려운 StdinReader 를 객체 그래프의 상단으로 배치한다.
    racingGame.run()
}

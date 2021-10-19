package racingcar.view

import racingcar.model.RacingCarGameResult

/**
 * 자동차 경주에 대한 결과를 출력하기 위한 인터페이스
 */
interface OutputView {

    fun showGameResult(result: RacingCarGameResult)
}

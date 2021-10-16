package racingcar.view

import racingcar.model.CarCount
import racingcar.model.GameCount

/**
 * 자동차 경주를 위한 정보를 입력받는 인터페이스
 */
interface InputView {

    fun getCarCount(): CarCount

    fun getGameCount(): GameCount
}

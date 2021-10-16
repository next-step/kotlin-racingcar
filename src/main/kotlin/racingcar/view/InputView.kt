package racingcar.view

import racingcar.model.CarCount
import racingcar.model.GameCount

interface InputView {

    fun getCarCount(): CarCount

    fun getGameCount(): GameCount
}

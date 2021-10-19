package racingcar.view.input

import racingcar.domain.CarNames
import racingcar.domain.NumberOfTrials

interface InputView {
    fun getCarNames(): CarNames
    fun getNumberOfTrials(): NumberOfTrials
}

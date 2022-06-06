package racingcar.view

import racingcar.domain.TrialCount

interface InputView {
    fun askCountOfTrial(): TrialCount
    fun askCarNames(): List<String>
}

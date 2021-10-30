package racingcar.views.inputviews

import racingcar.domain.dtos.GameInput

interface InputView {
    fun receiveInput(): GameInput
}

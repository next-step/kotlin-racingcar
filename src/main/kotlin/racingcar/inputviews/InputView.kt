package racingcar.inputviews

import racingcar.dtos.GameInput

interface InputView {
    fun receiveInput(): GameInput
}

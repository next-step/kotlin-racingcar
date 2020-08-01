package racingcar.racing.view

import racingcar.racing.const.EMPTY

interface View {
    fun input(message: String? = null): String?
    fun print(message: String = EMPTY)
    fun renderView()
    fun navigateTo(destination: View) {
        destination.renderView()
    }
}

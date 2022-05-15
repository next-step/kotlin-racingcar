package study.racingcar.view

import study.racingcar.domain.Car

data class CarView(
    val moved: Int,
    val state: String
) {
    fun print() {
        println(state)
    }
}

internal val Car.view
    get() = CarView(
        moved = this.getMoved(),
        state = "-".repeat(this.getMoved())
    )

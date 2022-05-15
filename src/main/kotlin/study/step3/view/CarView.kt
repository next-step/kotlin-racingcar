package study.step3.view

import study.step3.domain.Car

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

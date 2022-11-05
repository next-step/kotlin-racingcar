package racingcar.domain

import racingcar.view.InputView

class Car(
    var route: String = "-"
) : InputView {
    companion object {
        fun make(count: Long) =
            mutableListOf<Car>().apply {
                for (i in 0 until count) {
                    this.add(Car())
                }
            }
    }

    fun move() {
        this.route += "-"
    }
}

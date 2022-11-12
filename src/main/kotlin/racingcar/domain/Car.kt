package racingcar.domain

import racingcar.view.InputView

class Car : InputView {

    private var route: String = ""
    fun make() = generateCar(this.showQuestionAndGetInput("자동차 대수는 몇 대인가요?").toInt())

    fun generateCar(count: Int) =
        mutableListOf<Car>().apply {
            for (i in 0 until count) {
                this.add(Car())
            }
        }

    fun getRoute() = this.route

    fun move() {
        this.route += "-"
    }
}

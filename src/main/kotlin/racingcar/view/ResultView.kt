package racingcar.view

import racingcar.domain.Car

class ResultView {

    fun action(carList: List<Car>) {
        carList.forEach { println(ICON.repeat(it.distance)) }
    }

    companion object {
        private const val ICON = "\uD83C\uDFCE️"
    }
}

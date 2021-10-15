package racingcar

import racingcar.domain.Count
import racingcar.domain.Number
import racingcar.view.InputView

fun main() {
    val number = Number(InputView.inputCars())
    val count = Count(InputView.inputCounts())
}

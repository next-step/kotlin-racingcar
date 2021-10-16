package racingcar

import racingcar.domain.Cars
import racingcar.domain.Count
import racingcar.domain.Number
import racingcar.view.InputView

fun main() {
    val number = Number(InputView.inputCars())
    val cars = Cars(number)
    val count = Count(InputView.inputCounts())
    race(count, cars)
}

private fun race(count: Count, cars: Cars) {
    for (i in 0 until count.value) {
        cars.race()
    }
}

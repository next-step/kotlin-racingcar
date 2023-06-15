package racingcar

import racingcar.RacingCar.Companion.MAXIMUM_POWER_NUMBER
import racingcar.RacingCar.Companion.MINIMUM_POWER_NUMBER

fun main() {
    RacingCarView.printCarsInputView()
    val carCount = getIntValue()
    RacingCarView.printAttemptInputView()
    var attemptNumber = getIntValue()
    val cars = mutableListOf<RacingCar>()
    for (i in 0 until carCount) {
        cars.add(RacingCar())
    }
    RacingCarView.printResultView()
    while (attemptNumber-- > 0) {
        runCars(cars)
        RacingCarView.printCarsPosition(cars)
    }
}

fun getIntValue(): Int {
    val input = readlnOrNull()
    require(!input.isNullOrBlank() && (input.toInt() > MINIMUM_POWER_NUMBER)) { "0 보다 큰 숫자값을 입력하세요" }
    return input.toInt()
}

private fun runCars(cars: List<RacingCar>) {
    cars.forEach { it.tryMove(getZeroToRange(MAXIMUM_POWER_NUMBER)) }
}

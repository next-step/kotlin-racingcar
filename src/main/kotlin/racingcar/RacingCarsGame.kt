package racingcar

import racingcar.RacingCar.Companion.MINIMUM_POWER_NUMBER

fun main() {
    RacingCarView.printCarsInputView()
    val inputString = readln()
    val racingCars = RacingCars(inputString)
    RacingCarView.printAttemptInputView()
    var attemptNumber = getIntValue()
    RacingCarView.printResultView()
    while (attemptNumber-- > 0) {
        racingCars.runCars()
        RacingCarView.printCarsPosition(racingCars.cars)
    }
    RacingCarView.printWinnerCars(racingCars.getWinners())
}

fun getIntValue(): Int {
    val input = readlnOrNull()
    require(!input.isNullOrBlank() && (input.toInt() > MINIMUM_POWER_NUMBER)) { "0 보다 큰 숫자값을 입력하세요" }
    return input.toInt()
}

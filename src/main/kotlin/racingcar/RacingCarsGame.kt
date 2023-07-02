package racingcar

import racingcar.RacingCar.Companion.MINIMUM_POWER_NUMBER

fun main() {
    RacingCarView.printCarsInputView()
    val inputString = readln()
    val cars = StringParser.parseRacingCarString(inputString)
    val racingCars = RacingCars()
    racingCars.addCars(cars)
    RacingCarView.printAttemptInputView()
    val attemptNumber = getIntValue(readln())
    RacingCarView.printResultView()
    startGame(racingCars, attemptNumber)
    val winners = Winners(racingCars.cars)
    RacingCarView.printWinnerCars(winners.cars)
}

fun startGame(racingCars: RacingCars, numberOfGameRun: Int) {
    for (i in 0 until numberOfGameRun) {
        racingCars.runCars()
        RacingCarView.printCarsPosition(racingCars.cars)
    }
}

fun getIntValue(input: String): Int {
    require(input.isNotBlank() && (input.toInt() > MINIMUM_POWER_NUMBER)) { "0 보다 큰 숫자값을 입력하세요" }
    return input.toInt()
}

package step3

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
        run(cars)
        RacingCarView.printCarsPosition(cars)
    }
}

fun getIntValue(): Int = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("숫자값을 입력하세요")

private fun run(cars: List<RacingCar>) {
    cars.forEach { it.tryMove(getZeroToRange(9)) }
}

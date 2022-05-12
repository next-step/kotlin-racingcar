package racingcar

fun main() {

    RacingView.InputView.displayCarCount()
    val carCount: String? = readLine()
    require(!carCount.isNullOrBlank()) { IllegalArgumentException("잘못된 요청 입니다.") }

    RacingView.InputView.displayRoundCount()
    val roundCount: String? = readLine()
    require(!roundCount.isNullOrBlank()) { IllegalArgumentException("잘못된 요청 입니다.") }

    val readyCars = ready(carCount.toInt())

    val racing = Racing(Cars(readyCars))
    racing.start(roundCount.toInt(), DefaultMoveStrategy())

    RacingView.OutputView.display(racing.result())
}

fun ready(carCount: Int): List<Car> {
    val initCars = mutableListOf<Car>()
    for (i in 0 until carCount) {
        initCars.add(Car())
    }
    return initCars
}

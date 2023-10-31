package racingcar

class RacingCarService(
    private val inputProvider: InputProvider,
    private val resultProvider: ResultProvider,
) {
    fun run() {
        val carNumber = inputProvider.getIntInput("자동차 대수는 몇 대 인가요?")
        val attemptNumber = inputProvider.getIntInput("시도할 횟수는 몇 회 인가요?")

        val cars = MutableList(carNumber) { Car.create() }

        repeat(attemptNumber) {
            cars.forEach { it.move() }
            resultProvider.printItems(cars)
        }
    }
}

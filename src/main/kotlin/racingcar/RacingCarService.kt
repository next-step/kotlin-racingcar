package racingcar

class RacingCarService(
    private val inputProvider: InputProvider,
    private val resultProvider: ResultProvider,
) {
    fun run() {
        val carNames = inputProvider.getStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val attemptNumber = inputProvider.getIntInput("시도할 횟수는 몇 회 인가요?")
        val cars = carNames.map { Car.create(it) }

        repeat(attemptNumber) {
            cars.forEach { it.move() }
            resultProvider.printItems(cars)
        }

        val winners = getRacingWinners(cars)
        println("${winners.joinToString { it.name }}가 최종 우승했습니다.")
    }

    private fun getRacingWinners(cars: List<Car>): List<Car> {
        val maxMoveCount = cars.maxByOrNull { it.getMoveCount() }?.getMoveCount() ?: 0
        return cars.filter { it.getMoveCount() == maxMoveCount }
    }
}

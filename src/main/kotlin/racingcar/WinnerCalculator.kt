package racingcar

object WinnerCalculator {
    fun execute(cars: List<Car>): List<Car> {
        return cars
            .groupBy { it.position.value }
            .maxByOrNull { it.key }
            ?.value ?: throw IllegalStateException("우승자를 구할 수 없습니다.")
    }
}

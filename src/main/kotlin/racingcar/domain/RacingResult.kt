package racingcar.domain

data class RacingResult(
    val cars: List<Car>,
    val end: Boolean
) {
    fun winners(): List<Car> {
        check(end) { "아직 경주가 완료되지 않았습니다." }
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}

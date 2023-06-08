package racingcar.domain

class RacingGame(
    var attemptCount: Int,
    val cars: List<Car>
) {
    init {
        require(attemptCount >= 1) { "게임 생성에 필요한 시도 횟수는 1회 이상이어야 한다." }
        require(cars.isNotEmpty()) { "게임 생성에 필요한 자동차 대수는 1대 이상이어야 한다." }
    }

    fun run() {
        attemptCount--
        cars.forEach { it.move() }
    }
}

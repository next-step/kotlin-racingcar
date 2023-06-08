package racingcar.domain

class RacingGame(
    val attemptCount: Int,
    val cars: List<Car>
) {
    init {
        require(attemptCount >= 1) { "게임 생성에 필요한 시도횟수는 1회 이상이어야 한다." }
    }
}

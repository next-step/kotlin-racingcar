package racingcar.domain

import racingcar.domain.Car.Companion.createRandomMoveCar

class RacingGame(
    var attemptCount: Int,
    val cars: List<Car>
) {
    init {
        require(attemptCount > RUNNABLE_GAME_ATTEMPT_COUNT) { "게임 생성에 필요한 시도 횟수는 0보다 커야 한다." }
        require(cars.isNotEmpty()) { "게임 생성에 필요한 자동차 대수는 1대 이상이어야 한다." }
    }

    fun run(): List<Pair<String, Int>> {
        check(attemptCount > RUNNABLE_GAME_ATTEMPT_COUNT) { "시도 횟수가 남지 않아 게임을 더이상 실행할 수 없다." }
        attemptCount--
        return cars.map { Pair(it.name, it.move()) }
    }

    fun isRunnable(): Boolean = attemptCount != RUNNABLE_GAME_ATTEMPT_COUNT

    fun winner(): List<String> {
        check(!isRunnable()) { "게임이 종료되지 않아 우승자를 확인할 수 없다" }
        val winnerPosition = cars.maxOf { it.position }
        return cars.filter { it.position == winnerPosition }
            .map { it.name }
    }

    companion object {
        private const val RUNNABLE_GAME_ATTEMPT_COUNT = 0

        fun createRandomMoveCarRacingGame(attemptCount: Int, carNames: List<String>): RacingGame {
            return RacingGame(
                attemptCount = attemptCount,
                cars = carNames.map { createRandomMoveCar(it) }
            )
        }
    }
}

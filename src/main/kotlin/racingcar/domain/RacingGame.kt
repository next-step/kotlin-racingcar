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

    fun run(): List<Int> {
        check(attemptCount > RUNNABLE_GAME_ATTEMPT_COUNT) { "시도 횟수가 남지 않아 게임을 더이상 실행할 수 없다." }
        attemptCount--
        return cars.map { it.move() }
    }

    fun isRunnable(): Boolean = attemptCount != RUNNABLE_GAME_ATTEMPT_COUNT

    companion object {
        private const val RUNNABLE_GAME_ATTEMPT_COUNT = 0
        fun createRandomMoveCarRacingGame(attemptCount: Int, carCount: Int): RacingGame {
            return RacingGame(
                attemptCount = attemptCount,
                cars = (0 until carCount).map { createRandomMoveCar() }
            )
        }
    }
}

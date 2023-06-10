package racingcar.domain

import racingcar.domain.Cars.Companion.createRandomMoveCars

class RacingGame(
    attemptCount: Int,
    val cars: Cars
) {
    var attemptCount = attemptCount
        private set

    init {
        require(attemptCount > RUNNABLE_GAME_ATTEMPT_COUNT) { "게임 생성에 필요한 시도 횟수는 0보다 커야 한다." }
    }

    fun run() {
        check(attemptCount > RUNNABLE_GAME_ATTEMPT_COUNT) { "시도 횟수가 남지 않아 게임을 더이상 실행할 수 없다." }
        attemptCount--
        cars.run()
    }

    fun isRunnable(): Boolean = attemptCount != RUNNABLE_GAME_ATTEMPT_COUNT

    fun currentGameInfo() = cars.values.map { Pair(it.name, it.position) }

    fun winner(): List<String> {
        check(isRunnable().not()) { "게임이 종료되지 않아 우승자를 확인할 수 없다" }
        return cars.leadCarNames()
    }

    companion object {
        private const val RUNNABLE_GAME_ATTEMPT_COUNT = 0

        fun createRandomMoveCarRacingGame(attemptCount: Int, carNames: List<String>) =
            RacingGame(attemptCount = attemptCount, cars = createRandomMoveCars(carNames))
    }
}

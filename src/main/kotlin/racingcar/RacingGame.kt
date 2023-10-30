package racingcar

class RacingGame(
    private val racingGameEventListener: RacingGameEventListener,
    randomGenerator: RandomGenerator,
    names: List<String>,
) {
    private val cars: Cars

    init {
        cars = Cars(randomGenerator, names)
    }

    fun start(tryCount: Int) {
        racingGameEventListener.notify(RacingGameEvent.STARTED, this)
        repeat(tryCount) {
            cars.move()
            racingGameEventListener.notify(RacingGameEvent.MOVED, this)
        }
        racingGameEventListener.notify(RacingGameEvent.FINISHED, this)
    }

    fun positions(): List<Position> {
        return cars.positions()
    }

    fun winners(): List<String> {
        val winnerPosition = positions().reduce { p1, p2 -> if (p1.position > p2.position) p1 else p2 }

        return positions()
            .filter { winnerPosition.position == it.position }
            .map { it.name }
    }
}

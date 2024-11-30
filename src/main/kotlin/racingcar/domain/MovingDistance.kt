package racingcar.domain

object MovingDistance {
    const val MIN_RUN_NUMBER = 4
    const val GO = 1
    const val STOP = 0

    fun startRacing(
        tryCount: Int,
        movingStrategy: MovingStrategy,
    ): Int {
        var movingDistance = 0
        repeat(tryCount) {
            movingDistance += moveDecision(movingStrategy.createNumber())
        }
        return movingDistance
    }

    fun moveDecision(movingNumber: Int): Int {
        if (movingNumber >= MIN_RUN_NUMBER) {
            return GO
        }
        return STOP
    }

    fun winnerDistance(cars: List<Car>): Int {
        var winnerDistance = 0
        repeat(cars.size) {
            if (cars[it].movingDistance >= winnerDistance) {
                winnerDistance = cars[it].movingDistance
            }
        }
        return winnerDistance
    }
}

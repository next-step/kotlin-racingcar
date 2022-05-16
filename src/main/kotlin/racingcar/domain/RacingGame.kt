package racingcar.domain

class RacingGame(
    private var cars: Cars,
    private var tryNumber: TryNumber,
) {
    fun play(movementStrategy: () -> Int): List<Cars> {
        val result = mutableListOf<Cars>()
        while (tryNumber.isPlaying) {
            cars = cars.moveAll(movementStrategy)
                .also { result.add(it) }
            tryNumber = tryNumber.consume()
        }

        return result.toList()
    }
}

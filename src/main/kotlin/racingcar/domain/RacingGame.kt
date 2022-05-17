package racingcar.domain

class RacingGame(
    private var cars: Cars,
    private var tryNumber: TryNumber,
) {
    fun play(movementStrategy: () -> Int): RacingResult {
        val result = mutableListOf<Cars>()
        while (tryNumber.isPlaying) {
            cars = cars.moveAll(movementStrategy)
                .also { result.add(it) }
            tryNumber = tryNumber.consume()
        }

        return RacingResult(result.toList())
    }
}

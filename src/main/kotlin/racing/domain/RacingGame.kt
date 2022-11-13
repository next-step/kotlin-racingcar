package racing.domain

class RacingGame(
    private var cars: Cars,
    private val rounds: Rounds
) {
    constructor(carNames: String, tryCount: Int) : this(Cars(carNames), Rounds(tryCount))

    fun play(): Result {
        val result = mutableListOf<CarInfos>()

        while (rounds.hasNext()) {
            rounds.play()
            cars.move()
            result.add(cars.carInfos)
        }

        return Result(result.toList())
    }
}

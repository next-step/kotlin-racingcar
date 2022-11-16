package racing.domain

class RacingGame(
    private var cars: Cars,
    private val rounds: Rounds,
) {
    constructor(carNames: String, tryCount: Int, moveStrategy: MoveStrategy = RandomStrategy.instance)
            : this(Cars(carNames, moveStrategy), Rounds(tryCount))

    fun play(): Result {
        val result: List<CarInfos> = buildList {
            while (rounds.hasNext()) {
                rounds.play()
                add(cars.move())
            }
        }

        return Result(result)
    }
}

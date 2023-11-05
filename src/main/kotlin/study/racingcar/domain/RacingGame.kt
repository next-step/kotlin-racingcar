package study.racingcar.domain

class RacingGame {
    private var rounds: Int
    private val randomValueGenerator: RandomValueGenerator
    var cars: Cars
        private set

    constructor(
        carNames: List<String>,
        rounds: Int,
        randomValueGenerator: RandomValueGenerator = DefaultRandomValueGenerator()
    ) : this(Cars(carNames.map { Car(it) }), rounds, randomValueGenerator)

    constructor(cars: Cars, rounds: Int, randomValueGenerator: RandomValueGenerator) {
        this.rounds = rounds
        this.randomValueGenerator = randomValueGenerator
        require(rounds > 0) { "Number of rounds must be positive" }
        this.cars = cars
    }

    fun raceStart(onRoundFinished: (Cars) -> Unit) {
        repeat(rounds) {
            cars = cars.moveAll(randomValueGenerator)
            onRoundFinished(cars)
        }
    }

    fun getWinners(): Cars = Cars(
        cars.list.filter { car ->
            cars.list.none { other -> car != other && other.isWin(car) }
        }
    )
}

package study.racingcar

class Race {
    private var rounds: Int
    private val randomValueGenerator: () -> Int

    constructor(
        carNames: List<String>,
        rounds: Int,
        randomValueGenerator: () -> Int = { (0..9).random() }
    ) : this(Cars(carNames.map { Car(it) }), rounds, randomValueGenerator)

    constructor(cars: Cars, rounds: Int, randomValueGenerator: () -> Int) {
        this.rounds = rounds
        this.randomValueGenerator = randomValueGenerator
        require(rounds > 0) { "Number of rounds must be positive" }
        this.cars = cars
    }

    var cars: Cars
        private set

    fun run(onRoundFinished: (Cars) -> Unit) {
        repeat(rounds) {
            cars = moveAll(cars, randomValueGenerator)
            onRoundFinished(cars)
        }
    }

    fun move(car: Car, randomValue: Int): Car = if (randomValue >= MOVABLE_BASE_NUMBER) {
        car.copy(position = car.position + 1)
    } else {
        car
    }

    fun moveAll(cars: Cars, randomValueGenerator: () -> Int): Cars = Cars(
        cars.list.map { move(it, randomValueGenerator()) }
    )

    private fun isWin(car1: Car, other: Car) = car1.position > other.position

    fun getWinners(): Cars = Cars(
        cars.list.filter { car ->
            cars.list.none { other -> car != other && isWin(other, car) }
        }
    )

    private companion object {
        const val MOVABLE_BASE_NUMBER = 4
    }
}

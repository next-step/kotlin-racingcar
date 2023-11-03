package study.racingcar

class Race(
    carNames: List<String>,
    private var rounds: Int,
    private val randomValueGenerator: () -> Int = { (0..9).random() }
) {
    init {
        require(rounds > 0) { "Number of rounds must be positive" }
    }

    var cars: Cars = Cars(carNames.map { Car(it) })
        private set

    fun run(onRoundFinished: (Cars) -> Unit) {
        repeat(rounds) {
            cars = cars.moveAll(randomValueGenerator)
            onRoundFinished(cars)
        }
    }
}

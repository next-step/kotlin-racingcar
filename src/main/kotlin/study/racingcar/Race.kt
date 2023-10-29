package study.racingcar

class Race(
    numberOfCars: Int,
    private var rounds: Int,
    private val randomValueGenerator: () -> Int = { (0..9).random() }
) {
    var cars: Cars = Cars(List(numberOfCars) { Car() })
        private set

    fun run() {
        repeat(rounds) {
            cars = cars.moveAll(randomValueGenerator)
        }
    }
}

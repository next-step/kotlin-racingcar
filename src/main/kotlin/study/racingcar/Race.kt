package study.racingcar

class Race(
    numberOfCars: Int,
    rounds: Int,
    private val randomValueGenerator: () -> Int = { (0..9).random() }
) {
    var numberOfCars: Int = numberOfCars
        private set

    var rounds: Int = rounds
        private set

    var cars: List<Car> = List(numberOfCars) { Car() }
        private set

    fun run() {
        repeat(rounds) {
            cars.forEach { car ->
                val randomValue = randomValueGenerator()
                car.move(randomValue)
            }
        }
    }
}

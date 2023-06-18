package racing.domain

object RacingGame {

    const val MAX_BOUND = 10

    fun raceStart(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw IllegalArgumentException("자동차는 한대 이상이어야함")
        }
        cars.forEach {
            it.moveCar(CarRandomGenerator.createRandom(MAX_BOUND))
        }
    }
}

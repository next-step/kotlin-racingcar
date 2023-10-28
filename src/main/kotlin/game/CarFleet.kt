package game

class CarFleet private constructor(private val cars: List<Car>) {

    companion object {
        fun of(carNames: List<String>): CarFleet {
            return CarFleet(carNames.map { Car.of(it) })
        }
    }
}

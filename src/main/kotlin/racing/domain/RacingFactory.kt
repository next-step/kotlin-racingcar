package racing.domain

internal class RacingFactory {

    fun createRandomRacing(carNames: List<String>): Racing {
        val cars = carNames.map { Car(it) }
        return Racing(RacingCars(cars, RandomMovable()))
    }
}

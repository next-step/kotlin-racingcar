package racing.domain

class Cars(
    private val cars: List<Car>
) {

    fun race(): List<RacingPhaseRecord> = cars.map { it.move() }

    companion object {
        fun of(carNames: List<String>, forwardCondition: ForwardCondition): Cars {
            val cars = carNames.map { Car(name = it, forwardCondition = forwardCondition) }
            return Cars(cars)
        }
    }
}

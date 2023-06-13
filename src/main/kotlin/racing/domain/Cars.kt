package racing.domain

class Cars(
    private val cars: List<Car>
) {

    fun race(): RacingPhaseRecords {
        val racingPhaseRecords = cars.map { it.move() }
        return RacingPhaseRecords(racingPhaseRecords)
    }

    fun size(): Int = this.cars.size

    companion object {
        fun of(carNames: List<String>, forwardCondition: ForwardCondition): Cars {
            val cars = carNames.map { Car(name = it, forwardCondition = forwardCondition) }
            return Cars(cars)
        }
    }
}

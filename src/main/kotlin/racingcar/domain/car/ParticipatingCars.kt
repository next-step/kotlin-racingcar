package racingcar.domain.car

class ParticipatingCars(
    private val carList: List<Car>
) {
    fun initRace(outputFunction: () -> Unit) {
        IntRange(START_NUMBER, this.carList.size).forEach { _ ->
            outputFunction()
        }
    }

    fun move(outputFunction: (Int) -> Unit) {
        carList.forEach {
            it.move()
            outputFunction(it.currentPosition().toInt())
        }
    }

    private companion object {
        private const val START_NUMBER = 1
    }
}

package racingcar.domain.car

class ParticipatingCars(
    private val carList: List<Car>
) {
    fun initRace(outputFunction: (carName: String) -> Unit) {
        this.carList.forEach { car ->
            outputFunction(car.name)
        }
    }

    fun move(outputFunction: (Int, String) -> Unit) {
        carList.forEach {
            it.move()
            outputFunction(it.currentPosition().toInt(), it.name)
        }
    }
}

package racingcar.domain

class Cars(val cars: List<Car>) {
    val size: Int
        get() {
            return cars.size
        }

    fun driveCars() {
        cars.forEach { it.drive() }
    }

    fun getWinners(): Cars {
        val maxPosition = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxPosition }
        return Cars(winners)
    }

    companion object {
        fun createTo(carNames: CarNames): Cars {
            return Cars(
                List(carNames.size) {
                    Car(carNames.findNameByIndex(it), DriveConditionImpl())
                }
            )
        }
    }
}

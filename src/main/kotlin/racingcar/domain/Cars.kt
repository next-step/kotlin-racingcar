package racingcar.domain

class Cars(val cars: List<Car>) {
    val size: Int
        get() {
            return cars.size
        }

    fun driveCars() {
        cars.forEach { it.drive() }
    }

    fun getWinners(): String {
        val maxPosition = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxPosition }
        return winners.joinToString(",") { it.name.name }
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

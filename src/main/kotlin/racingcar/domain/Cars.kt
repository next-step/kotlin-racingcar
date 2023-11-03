package racingcar.domain

class Cars(val cars: List<Car>) {
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
                List(carNames.getSize()) {
                    Car(carNames.findNameByIndex(it), DriveConditionImpl())
                }
            )
        }
    }
}

package racingcar.domain

class Cars(names: List<String>) {
    val carList: List<Car> = names.map { Car(it) }

    fun attempt(moveCondition: MoveCondition) {
        for (car in carList) {
            car.go(moveCondition)
        }
    }

    fun countCars() = carList.size

    fun getWinners(): List<String> {
        val maxScore: Int = carList.maxOfOrNull { car -> car.position } ?: 0
        return carList.filter { it.position == maxScore }.map { it.getName() }
    }
}

package racingcar.domain

class Cars(names: List<String>, moveCondition: MoveCondition) {
    val carList: List<Car> = names.map { Car(it, moveCondition) }

    fun attempt() {
        for (car in carList) {
            car.go()
        }
    }

    fun countCars() = carList.size

    fun getWinners(): List<String> {
        val maxScore: Int = carList.maxOfOrNull { car -> car.position } ?: 0
        return carList.filter { it.position == maxScore }.map { it.getName() }
    }
}

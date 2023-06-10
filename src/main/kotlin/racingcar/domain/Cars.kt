package racingcar.domain

class Cars(names: List<String>) {
    val carList: List<Car> = List(names.size) { Car(names[it]) }

    fun attempt(moveCondition: MoveCondition) {
        for (car in carList) {
            car.go(moveCondition)
        }
    }

    fun countCars() = carList.size

    fun getWinners(): List<String> {
        val maxScore: Int = carList.stream()
            .mapToInt { car -> car.position }
            .max()
            .orElse(0)
        return carList.filter { it.position == maxScore }.map { it.getCarNameString() }
    }
}

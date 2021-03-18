package racingcar.domain

class CarCollection(userNames: List<String>) {

    val cars: List<Car> = userNames.map { Car(it) }

    fun tryMoveCars(conditionNumbers: List<Int>) {
        cars.zip(conditionNumbers)
            .forEach { (car, number) -> car.tryMove(number) }
    }

    fun size(): Int = cars.size

    fun getWinner(): List<Car> {
        val maxPosition = cars.map { it.position }.max()
        return cars.filter { it.position == maxPosition }
    }
}

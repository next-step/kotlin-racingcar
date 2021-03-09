package study.racingcar.domain

class Cars(racedCars: List<Car>) {
    val racedCars: List<Car> = racedCars.map { Car(it.carName, it.moveCount) }

    override fun toString(): String {
        return racedCars.joinToString("\n")
    }
}

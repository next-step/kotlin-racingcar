package racingcar.domain

class Race(
    val cars: List<Car>,
) {
    fun proceedRound(cars: List<Car>): List<Car> {
        cars.forEach {
            it.action()
        }
        return cars
    }

    fun getWinner() = Judges(cars).pickWinner()

    companion object {
        fun create(names: List<String>): Race = Race(
            names.map { name -> Car(name) }
        )
    }
}

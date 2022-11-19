package study.racingcar.car

object CarFactory {
    fun createCars(names: List<String>): List<Car> {
        return names.map { name ->
            Car(name)
        }
    }
}

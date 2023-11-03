package racingcar.domain.car

object CarGenerator {
    fun create(names: List<String>): List<Car> = names.map {
        Car(name = CarName(it))
    }
}

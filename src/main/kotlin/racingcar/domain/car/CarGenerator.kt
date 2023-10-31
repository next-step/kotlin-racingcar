package racingcar.domain.car

object CarGenerator {
    fun create(names: List<CarName>): List<Car> = names.map {
        Car(name = it)
    }
}

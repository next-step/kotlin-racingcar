package racingcar.domain.car

object CarGenerator {
    fun create(names: List<CarName>): List<Car> = names.mapIndexed { index, name ->
        Car(
            order = index,
            name = name,
        )
    }
}

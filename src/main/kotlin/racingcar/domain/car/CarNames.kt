package racingcar.domain.car

data class CarNames(private val names: List<String>) {

    fun mapToCar(): List<Car> = names.map(::Car)
}

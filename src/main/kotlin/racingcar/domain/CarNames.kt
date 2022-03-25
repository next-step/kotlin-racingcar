package racingcar.domain

data class CarNames(private val names: List<String>) {

    fun mapToCar(): List<Car> = names.map { name -> Car(name) }
}
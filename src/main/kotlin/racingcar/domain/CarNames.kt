package racingcar.domain

class CarNames(names: List<String>) {
    val names: List<CarName>
    init {
        this.names = List(names.size) { CarName(names[it]) }
    }
}

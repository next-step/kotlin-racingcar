package racingcar.domain

class CarNames(names: List<String>) {
    val names: List<CarName>

    init {
        this.names = List(names.size) { CarName(names[it]) }
    }

    fun getSize(): Int {
        return names.size
    }

    fun findNameByIndex(index: Int): CarName {
        return names[index]
    }
}

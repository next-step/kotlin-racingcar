package racingcar.domain

class CarNames(names: List<String>) {
    private val names: List<CarName>
    val size: Int
        get() {
            return names.size
        }

    init {
        this.names = List(names.size) { CarName(names[it]) }
    }

    fun findNameByIndex(index: Int): CarName {
        return names[index]
    }
}

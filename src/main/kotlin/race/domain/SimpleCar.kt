package race.domain

class SimpleCar(name: String) {
    val carName: CarName
    var location = 0
        private set

    init {
        carName = CarName(name)
    }

    fun move(value: Int) {
        if (value >= MOVE_THRESHOLD) location++
    }

    companion object {
        const val MOVE_THRESHOLD = 4
    }
}

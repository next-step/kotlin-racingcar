package race.domain

class SimpleCar(val carName: CarName, location: Int = 0) {
    var location = location
        private set

    constructor(name: String) : this(CarName(name))

    fun move(value: Int) {
        if (value >= MOVE_THRESHOLD) location++
    }

    companion object {
        const val MOVE_THRESHOLD = 4
    }
}

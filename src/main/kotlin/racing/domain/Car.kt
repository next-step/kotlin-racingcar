package racing.domain

class Car(val name: CarName, private val _location: Location = Location()) {
    var location: Location = this._location
        private set

    constructor(name: String, location: Int) : this(CarName(name), Location(location))

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            location = location.add()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

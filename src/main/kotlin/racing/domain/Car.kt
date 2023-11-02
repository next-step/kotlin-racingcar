package racing.domain

class Car(val name: CarName) {
    var location: Location = Location(0)
        private set

    constructor(name: CarName, location: Location) : this(name) {
        this.location = location
    }

    constructor(name: String, location: Int) : this(CarName(name)) {
        this.location = Location(location)
    }

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

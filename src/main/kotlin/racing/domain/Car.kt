package racing.domain

class Car(val name: CarName) : Comparable<Car> {
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

    fun isDraw(otherCar: Car): Boolean {
        return location == otherCar.location
    }

    override fun compareTo(otehrCar: Car): Int {
        return location.compareTo(otehrCar.location)
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

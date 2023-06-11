package racingcar.domain

import racingcar.domain.Location.Companion.initialLocation

typealias CarId = Long

interface CarRef {
    val carId: CarId
}

class Car(override val carId: CarId) : CarRef {
    private var location: Location = initialLocation

    fun location(): Location = location

    fun moveForward(): Location {
        location = location.nextLocation()
        return location
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (carId != other.carId) return false

        return true
    }

    override fun hashCode(): Int {
        return carId.hashCode()
    }
}

data class Location(val location: Long) {
    fun nextLocation(): Location = Location(location + 1)

    companion object {
        val initialLocation = Location(0)
    }
}

fun Int.toLocation() = Location(this.toLong())

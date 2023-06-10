package racingcar.domain

import racingcar.domain.Location.Companion.initialLocation

class Car {
    private var location: Location = initialLocation

    fun location(): Location = location

    fun moveForward(): Location {
        location = location.nextLocation()
        return location
    }
}

data class Location(val location: Long) {
    fun nextLocation(): Location = Location(location + 1)

    companion object {
        val initialLocation = Location(0)
    }
}

fun Int.toLocation() = Location(this.toLong())
package racing.domain

@JvmInline
value class Location(val location: Int = 0) : Comparable<Location> {
    fun add(): Location {
        return Location(location.plus(1))
    }

    override fun compareTo(otherLocation: Location): Int {
        return location.compareTo(otherLocation.location)
    }
}

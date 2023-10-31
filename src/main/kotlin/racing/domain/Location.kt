package racing.domain

@JvmInline
value class Location(val location: Int = 0) {
    fun add(): Location {
        return Location(location.plus(1))
    }
}

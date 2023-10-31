package racing.domain

data class Location(val location: Int = 0) {
    fun add(): Location {
        return Location(location.plus(1))
    }
}

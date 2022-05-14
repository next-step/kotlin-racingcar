package racingcar.domain

data class CarRecord(
    private val value: Pair<CarName, Location>
) {
    val carName get() = value.first
    val location get() = value.second
}

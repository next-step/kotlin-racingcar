package racingcar.domain.racing

import racingcar.domain.car.CarLocation
import racingcar.domain.car.CarName

data class Record(
    val name: CarName,
    val location: CarLocation
) {
    constructor(name: String, location: Int) : this(CarName(name), CarLocation(location))

    fun isSameLocationAs(other: Record): Boolean {
        return this.location == other.location
    }
}

package racingcar.domain

import racingcar.domain.car.CarLocation
import racingcar.domain.car.CarName

data class Record(
    val name: CarName,
    val location: CarLocation
) {
    fun isSameLocationAs(other: Record): Boolean {
        return this.location == other.location
    }
}

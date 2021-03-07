package racingcar.racing

import racingcar.racing.car.CarLocation
import racingcar.racing.car.CarName

data class Record(
    val name: CarName,
    val location: CarLocation
) {
    fun isSameLocationAs(other: Record): Boolean {
        return this.location == other.location
    }
}

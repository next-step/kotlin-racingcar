package step3.domain.car.container

import step3.domain.car.RacingCar

interface RacingCarContainer {

    val carList: List<RacingCar>

    fun addRacingCar(carName: String)

    fun isNotFullRacingCar(): Boolean

    fun isFullRacingCar(): Boolean = !isNotFullRacingCar()
}

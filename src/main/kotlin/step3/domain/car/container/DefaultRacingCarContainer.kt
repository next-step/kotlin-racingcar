package step3.domain.car.container

import step3.domain.car.RacingCar

class DefaultRacingCarContainer(
    private val totalCarCount: Int,
) : RacingCarContainer {

    override val carList = mutableListOf<RacingCar>()

    override fun addRacingCar(carName: String) {
        check(isNotFullRacingCar()) { "Racing car is already full. Cannot add new racing car" }

        carList.add(RacingCar(carName))
    }

    override fun isNotFullRacingCar(): Boolean = carList.size < totalCarCount
}

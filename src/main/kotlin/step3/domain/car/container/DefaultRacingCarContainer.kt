package step3.domain.car.container

import step3.domain.car.RacingCar

class DefaultRacingCarContainer(
    private val totalCarCount: Int,
) : RacingCarContainer {

    init {
        require(totalCarCount > 0)
    }

    override val carList: List<RacingCar> = mutableListOf()

    override fun addRacingCar(carName: String) {
        check(isNotFullRacingCar()) { "Racing car is already full. Cannot add new racing car" }

        (carList as MutableList).add(RacingCar(carName))
    }

    override fun isNotFullRacingCar(): Boolean = carList.size < totalCarCount
}

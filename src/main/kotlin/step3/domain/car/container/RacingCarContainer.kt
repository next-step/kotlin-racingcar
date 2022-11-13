package step3.domain.car.container

import step3.domain.car.RacingCar

class RacingCarContainer(
    private val totalCarCount: Int
) {

    init {
        require(totalCarCount > 0)
    }

    private val _carList: MutableList<RacingCar> = mutableListOf()

    val carList: List<RacingCar>
        get() = _carList

    fun addRacingCar() {
        check(isNotFullRacingCar()) { "Racing car is already full. Cannot add new racing car" }

        _carList.add(RacingCar())
    }

    fun isNotFullRacingCar(): Boolean = _carList.size < totalCarCount

    fun isFullRacingCar(): Boolean = !isNotFullRacingCar()
}

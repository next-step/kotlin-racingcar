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

    fun addRacingCar(carName: String) {
        check(isNotFullRacingCar()) { "Racing car is already full. Cannot add new racing car" }

        _carList.add(RacingCar(carName))
    }

    fun getWinnerRacingCarList(): List<RacingCar> {
        val winningCar = carList.maxOrNull() ?: return emptyList()

        return carList.filter { it.isDraw(winningCar) }
    }

    fun isNotFullRacingCar(): Boolean = _carList.size < totalCarCount

    fun isFullRacingCar(): Boolean = !isNotFullRacingCar()
}

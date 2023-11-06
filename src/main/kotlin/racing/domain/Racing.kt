package racing.domain

import racing.domain.car.Car
import racing.domain.car.CarManager

class Racing(private val carManager: CarManager) {

    private val _racingResultList = mutableListOf<List<Car>>()
    val racingResultList: List<List<Car>>
        get() = _racingResultList.toList()

    fun startRacing(racingCnt: Int) {
        for (i in 0 until racingCnt) {
            carManager.moveCar()
            saveRacingResult()
        }
    }

    private fun saveRacingResult() {
        val carList = mutableListOf<Car>()
        carManager.getCarList().map {
            carList.add(it.copy())
        }
        _racingResultList.add(carList)
    }
}

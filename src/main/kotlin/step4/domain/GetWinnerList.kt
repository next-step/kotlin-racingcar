package step4.domain

import step4.data.RacingCar

object GetWinnerList {
    fun getWinnerList(racingCars: List<RacingCar>): List<RacingCar> {
        val maxMove = racingCars.maxOf { it.moveCount }
        return racingCars.filter { it.moveCount == maxMove }
    }
}

package racingcar.domain.racing

import racingcar.domain.car.CarList

class RacingGame(
    val carList: CarList,
    val racingCondition: RacingCondition
) {

    fun start() {
        carList.race(racingCondition)
    }

    fun getWinner() = carList.getWinner()
}

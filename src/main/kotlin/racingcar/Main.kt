package racingcar

import racingcar.domain.RacingCars
import racingcar.view.getCarName
import racingcar.view.getPlayTime
import racingcar.view.printCurrentLocation
import racingcar.view.printWinner

fun main() {

    val playTime = getPlayTime()

    val racingCars = RacingCars(getCarName())

    repeat(playTime) {
        printCurrentLocation(racingCars.playGameOnce())
    }

    printWinner(racingCars.getWinner())
}

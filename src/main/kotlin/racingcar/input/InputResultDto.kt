package racingcar.input

import racingcar.input.value.NumberOfCars
import racingcar.input.value.PlayTime

class InputResultDto(private val numberOfCars: NumberOfCars, private val playTime: PlayTime) {
    fun getNumberOfCars(): Int {
        return numberOfCars.getNumberOfCars()
    }

    fun getPlayTime(): Int {
        return playTime.getPlayTime()
    }
}

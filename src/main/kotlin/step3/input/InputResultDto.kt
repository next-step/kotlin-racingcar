package step3.input

import step3.input.value.NumberOfCars
import step3.input.value.PlayTime

class InputResultDto(private val numberOfCars: NumberOfCars, private val playTime: PlayTime) {
    fun getNumberOfCars(): Int {
        return numberOfCars.getNumberOfCars()
    }

    fun getPlayTime(): Int {
        return playTime.getPlayTime()
    }
}

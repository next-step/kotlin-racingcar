package racingcar.input

import racingcar.input.value.NumberOfCars
import racingcar.input.value.PlayTime

data class InputResultDto(private val NumberOfCars: NumberOfCars, private val playTime: PlayTime) {
    val getNumberOfCars get() = NumberOfCars.value
    val getPlayTime get() = playTime.value
}

package racingcar.domain.car

import racingcar.domain.numberpicker.NumberPicker

class Cars(val cars: List<Car>) {
    fun play(numberPicker: NumberPicker) {
        cars.forEach { car -> car.move(numberPicker.getNumber()) }
    }
}
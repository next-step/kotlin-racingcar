package racingcar.domain.car

import racingcar.domain.numberpicker.NumberPicker

class Cars(val cars: List<Car>) {
    fun play(numberPicker: NumberPicker): Cars {
        return Cars(cars.map { car -> car.move(numberPicker.getNumber()) })
    }

    fun getWinners(): Cars {
        val maxiPosition = cars.maxOf { it.position }
        return Cars(cars.filter { it.position == maxiPosition })
    }
}
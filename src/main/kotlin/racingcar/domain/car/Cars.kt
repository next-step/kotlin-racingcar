package racingcar.domain.car

import racingcar.domain.Name
import racingcar.domain.numberpicker.NumberPicker

class Cars(val cars: List<Car>) {
    fun play(numberPicker: NumberPicker): Cars {
        return Cars(cars.map { car -> car.moveOverCondition(numberPicker.getNumber()) })
    }

    fun getWinners(): Cars {
        val maxiPosition = cars.maxOf { it.position }
        return Cars(cars.filter { it.position == maxiPosition })
    }

    companion object {
        fun from(names: List<Name>): Cars {
            return Cars(names.map { Car(it) })
        }
    }
}

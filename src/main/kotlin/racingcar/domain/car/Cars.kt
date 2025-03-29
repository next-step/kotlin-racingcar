package racingcar.domain.car

import racingcar.domain.Name
import racingcar.domain.numberpicker.NumberPicker

class Cars(val cars: List<Car>) {
    fun play(numberPicker: NumberPicker): Cars {
        return Cars(cars.map { car -> car.moveOverCondition(numberPicker.getNumber()) })
    }

    fun getWinners(): Winners {
        val maxPosition = cars.maxOf { it.position }
        return Winners(cars.filter { it.position == maxPosition })
    }

    companion object {
        fun from(names: List<Name>): Cars {
            return Cars(names.map { Car(it) })
        }
    }
}

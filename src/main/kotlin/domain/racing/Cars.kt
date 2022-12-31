package domain.racing

import util.racing.converter.PositionSymbolConverter
import util.racing.generator.NumberGenerator

class Cars(private val cars: List<Car>) {

    fun move(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun toResult(): Map<Car, String> {
        return cars.associateWith { PositionSymbolConverter.converter(it.getPosition()) }
    }

    companion object {
        fun of(names: List<Name>): Cars {
            val cars = names
                .map { Car(it) }
                .toList()

            return Cars(cars)
        }
    }
}

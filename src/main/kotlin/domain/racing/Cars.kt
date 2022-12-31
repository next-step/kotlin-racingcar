package domain.racing

import util.racing.converter.PositionSymbolConverter
import util.racing.generator.NumberGenerator
import java.util.stream.IntStream
import kotlin.streams.toList

class Cars(private val cars: List<Car>) {

    fun move(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun toResult(): Map<Car, String> {
        return cars.associateWith { PositionSymbolConverter.converter(it.getPosition()) }
    }

    companion object {
        fun of(carAmount: Int): Cars {
            val cars = IntStream.range(0, carAmount)
                .mapToObj { Car() }
                .toList()

            return Cars(cars)
        }
    }
}

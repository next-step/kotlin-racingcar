package domain.racing

import util.racing.converter.PositionSymbolConverter
import util.racing.generator.NumberGenerator
import java.util.stream.IntStream
import kotlin.streams.toList

class Cars(private val cars: List<Car>) {

    companion object {
        fun of(carAmount: Int): Cars {
            val cars = IntStream.range(0, carAmount)
                .mapToObj { _ -> Car() }
                .toList()

            return Cars(cars)
        }
    }

    fun move(numberGenerator: NumberGenerator) {
        cars.forEach { it -> it.move(numberGenerator.generate()) }
    }

    fun toResult(): Map<Car, String> {
        return cars.associateWith { it -> PositionSymbolConverter.converter(it.getPosition()) }
    }
}

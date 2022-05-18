package racingcar.domain.collection

import racingcar.domain.Car
import racingcar.domain.Record
import racingcar.utils.NumberGenerator

class Cars(
    private val cars: List<Car>
) {
    fun run() {
        cars.forEach(Car::run)
    }

    fun getCarRecords(): List<Record> {
        val records = mutableListOf<Record>()

        getPositions().forEach { position ->
            records.add(Record(position.first, position.second))
        }

        return records
    }

    private fun getPositions(): List<Pair<String, Int>> {
        return cars.map { Pair(it.carName, it.position) }
    }

    companion object {
        fun generateCars(names: List<String>, numberGenerator: NumberGenerator): Cars {
            val cars = mutableListOf<Car>()
            names.forEach { carName ->
                cars.add(Car(carName, numberGenerator))
            }

            return Cars(cars)
        }
    }
}

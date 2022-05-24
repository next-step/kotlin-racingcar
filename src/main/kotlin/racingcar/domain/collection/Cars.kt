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

    fun getCarRecords(): RoundRecord {
        val records = cars.map { car -> Record(car.carName, car.position) }
        return RoundRecord(records)
    }

    companion object {
        fun generateCars(names: List<String>, numberGenerator: NumberGenerator): Cars {
            val cars: List<Car> = names.map { carName -> Car(carName, numberGenerator) }
            return Cars(cars)
        }
    }
}

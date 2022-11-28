package racing.domain

import racing.MoveStrategy

data class Cars(private val cars: List<Car>) {
    companion object {
        fun init(names: List<String>, moveStrategy: MoveStrategy): Cars {
            val carList = names.map { Car(moveStrategy = moveStrategy, name = Name.of(it)) }
            return Cars(carList)
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getDistancesWithNames(): List<Pair<Name, Int>> {
        return cars.map { car -> Pair(car.name, car.distance) }
    }

    fun getWinners(): List<Name> {
        return cars
            .groupBy(Car::distance, Car::name)
            .maxByOrNull { it.key }?.value ?: throw IllegalStateException("승자가 없습니다.")
    }
}

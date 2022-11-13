package racing

data class Cars(private val cars: List<Car>) {
    companion object {
        fun init(listOfNames: List<String>, moveStrategy: MoveStrategy): Cars {
            val carList = listOfNames.map { name -> Car(moveStrategy = moveStrategy, name = Name.of(name)) }
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
        return cars.sorted()
            .groupBy(Car::distance, Car::name)
            .maxByOrNull { it.key }!!.value
    }
}

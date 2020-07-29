package racingcar

class Record(cars: List<Car>) {
    private val _carNamesAndDistances = LinkedHashMap<String, Int>()
    val carNamesAndDistances: LinkedHashMap<String, Int>
        get() = _carNamesAndDistances

    init {
        cars.forEach { car ->
            _carNamesAndDistances[car.name] = car.distance
        }
    }
}

package carracing.model.model

typealias Location = Int

class Racing(
    numberOfCar: Int,
    val rule: Rule = Rule.RandomRule()
) {
    val cars: List<Car> = List(numberOfCar) { index -> Car(index) }
    val locations: LinkedHashMap<Car, Location> = linkedMapOf<Car, Location>().apply {
        cars.forEach { this[it] = 0 }
    }

    fun progress() {
        cars.forEach {
            locations[it] = locations[it]?.plus(it.move(rule))
                ?: throw IllegalArgumentException("car that didn't participate in racing")
        }
    }

    fun takeSnapshot() = Snapshot(LinkedHashMap(locations))
}

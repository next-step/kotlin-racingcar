package model

class Race(
    names: List<String>
) {
    private val cars = names.map { Car(it) }
    private val records = mutableListOf<List<Record>>()

    fun doRace() {
        cars.forEach {
            it.tryToGo()
        }
        records.add(cars.map { Record(it) })
    }

    fun getRecords() = records

    data class Record(
        val distance: Int,
        val name: String
    ) {
        constructor(car: Car) : this(car.getDistance(), car.name)
    }
}

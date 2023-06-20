package step3.domain

class CarMaker(
    private val carMover: CarMover
) {
    fun make(names: List<String>) : List<Car> {
        val list = mutableListOf<Car>()
        names.forEach { list += Car(carMover, it) }
        return list
    }
}
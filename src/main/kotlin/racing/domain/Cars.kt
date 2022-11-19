package racing.domain

class Cars(names: String) : Iterable<Car> {

    private val list: List<Car>

    init {
        list = names.split(SEPARATOR).map {
            Car(it)
        }
    }

    fun count() = list.size

    fun race(movable: () -> Int) {
        list.forEach {
            car ->
            car.move(movable.invoke())
        }
    }
    override fun iterator(): Iterator<Car> = list.iterator()

    companion object {
        const val SEPARATOR = ","
    }
}

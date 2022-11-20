package racing.domain

class Cars(count: Int) : Iterable<Car> {

    private val list: List<Car>

    init {
        list = List(count) {
            Car()
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
}

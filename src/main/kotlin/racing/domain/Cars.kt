package racing.domain

class Cars(list: List<Car>) : Iterable<Car> {

    private val list = list
    constructor(names: Array<String>) : this(names.map { Car.produce(it) })

    fun count() = list.size

    fun race(movable: () -> Int) {
        list.forEach {
            car ->
            car.move(movable())
        }
    }
    override fun iterator(): Iterator<Car> = list.iterator()
}

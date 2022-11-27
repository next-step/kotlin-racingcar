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

    fun isWinnerPosition() = list.maxOf { it.position }

    fun isWinner() = list.filter { it.position == isWinnerPosition() }

    override fun iterator(): Iterator<Car> = list.iterator()
}

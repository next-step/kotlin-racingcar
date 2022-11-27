package racing.domain

class Cars(private val list: List<Car>) : Iterable<Car> {
    constructor(names: Array<String>) : this(names.map { Car.produce(it) })

    fun count() = list.size

    fun race(movable: () -> Int) {
        list.forEach {
            car ->
            car.move(movable())
        }
    }

    private fun isWinnerPosition() = list.maxOf { it.position }

    fun isWinner() = list.filter { it.position == isWinnerPosition() }

    override fun iterator(): Iterator<Car> = list.iterator()
}

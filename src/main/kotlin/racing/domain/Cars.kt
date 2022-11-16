package racing.domain

import java.util.stream.IntStream
import kotlin.streams.toList

class Cars(count: Int) : Iterable<Car> {

    private val list: List<Car>

    init {
        list = IntStream.range(0, count)
            .mapToObj {
                Car(it.toString())
            }.toList()
    }

    fun count() = list.size
    override fun iterator(): Iterator<Car> {
        return list.iterator()
    }
}

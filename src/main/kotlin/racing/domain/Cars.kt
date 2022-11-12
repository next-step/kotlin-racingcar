package racing.domain

import java.util.stream.Collectors.toList
import java.util.stream.IntStream
import kotlin.streams.toList

class Cars(count: Int, var index: Int = 0) : Iterator<Car> {

    private val list: List<Car>

    init {
        list = IntStream.range(0, count)
            .mapToObj {
                Car(it.toString())
            }.collect(toList())
    }

    override fun hasNext(): Boolean {
        return list.size > index
    }

    override fun next(): Car {
        return list[index++]
    }

    fun count() = list.size
}

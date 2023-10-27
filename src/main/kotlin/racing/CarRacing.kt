package racing

import org.assertj.core.util.VisibleForTesting
import kotlin.random.Random

object CarRacing {
    @VisibleForTesting
    fun create(input: Pair<Int, Int>): List<List<Car>> {
        return List(input.first) { List(input.second) { Car() } }
    }

    fun race(input: Pair<Int, Int>): List<List<String>> {
        val list = create(input)
        return list.mapIndexed { tryIndex, cars ->
            cars.forEachIndexed { carIndex, _ ->
                val isMove = isMove { random(0..9) }
                if (isMove) {
                    move(list, tryIndex, carIndex)
                }
            }
            cars.map { it.getResult() }
        }
    }

    @VisibleForTesting
    fun random(range: IntRange) = Random.nextInt(range.first, range.last)

    @VisibleForTesting
    fun isMove(intSupplier: () -> Int) = intSupplier() >= 4

    private fun move(input: List<List<Car>>, tryIndex: Int, carIndex: Int) {
        for (i in tryIndex until input.size) {
            input[i][carIndex].move()
        }
    }
}

package racing

import org.assertj.core.util.VisibleForTesting
import kotlin.random.Random

fun main() {
    val input = InputView.inputForRacing()
    val result = CarRacing.race(input)
    ResultView.printRacingResult(result)
}

object CarRacing {
    fun race(input: List<List<Car>>): List<List<String>> {
        return input.mapIndexed { tryIndex, cars ->
            cars.forEachIndexed { carIndex, _ ->
                val isMove = isMove { random(0..9) }
                if (isMove) {
                    move(input, tryIndex, carIndex)
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

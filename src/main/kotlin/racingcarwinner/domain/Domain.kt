package racingcarwinner.domain

import kotlin.random.Random

class Car(name: String, position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    val name: String = name

    fun move() {
        val randomresult = Random.nextInt()
        movesample(randomresult)
    }

    fun movesample(orders: Int) {
        if (orders > 4) position++
        else position
    }

    fun Isin(position: Int): Boolean = this.position == position

    companion object {

        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
    }
}

class RacingGame(var cars: List<Car>) {

    fun findwinner(): List<Car> {
        val max = maximumPosition()
        return cars.filter { it.Isin(max!!) }
    }

    fun maximumPosition(): Int? =cars.map { it.position }.max() ?:0





}



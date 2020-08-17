package racingcarwinner.domain

import racingcarwinner.view.OutputView
import kotlin.random.Random

class Car(val name: String, position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    private val randomNumber: Int
        get() = Random.nextInt(MAX_BOUND)

    fun move() {
        moveSample(randomNumber)
    }

    fun moveSample(orders: Int) {
        if (orders > FORWARD_NUMBER) position++
        else position
    }

    fun isIn(position: Int): Boolean = this.position == position

    companion object {

        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
        private const val MAX_BOUND = 9
    }
}

class RacingGame(private val carName: String?) {
    var cars = mutableListOf<Car>()

    init {
        val carList = carName!!.split(",")
        carList.map { car -> cars.add(Car(car)) }
    }

    fun findWinner() {
        val max = maximumPosition()
        val winner = cars.filter { it.isIn(max!!) }
        OutputView.printwinner(winner)
    }

    fun moveTrack(circuit: Int) {
        repeat(circuit) {
            cars.map { it.move() }
            OutputView.printcircuit(cars)
        }
    }

    fun maximumPosition(): Int? = cars.map { it.position }.max() ?: 0
}

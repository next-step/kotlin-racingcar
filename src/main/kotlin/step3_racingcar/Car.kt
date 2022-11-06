package step3_racingcar

import step3_racingcar.strategy.ForwardStrategy

class Car(
    private var distance: MutableList<Char> = mutableListOf(),
    private val strategy: ForwardStrategy
) {
    fun move() {
        if (strategy.move()) this.distance.add(SPACE)
    }

    companion object {
        private const val SPACE = '-'
    }
}

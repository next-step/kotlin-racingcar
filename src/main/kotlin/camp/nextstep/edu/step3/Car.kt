package camp.nextstep.edu.step3

import kotlin.random.Random

class Car(id: Int) {

    private val engine: Engine = Engine(id)

    fun raceOn(track: Track, moveCount: Int) {
        engine.move()
        TODO()
    }

    private class Engine(id: Int) {
        private val random = Random(id)
        fun move(): Boolean = random.nextInt(0, 9) >= 4
    }
}

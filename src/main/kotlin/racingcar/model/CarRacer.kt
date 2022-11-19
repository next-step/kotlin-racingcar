package racingcar.model

/**
 * 자동차 경주자
 */
class CarRacer {

    constructor()

    constructor(racer: CarRacer) {
        position = racer.position
    }

    var position: Int = 0
        private set

    fun moveTo(randomCount: Int) {
        if (randomCount < 4) return
        position++
    }
}

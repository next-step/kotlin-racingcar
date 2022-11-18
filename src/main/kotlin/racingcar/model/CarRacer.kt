package racingcar.model

/**
 * 자동차 경주자
 */
class CarRacer {

    var position: Int = 0
        private set

    fun moveTo(randomCount: Int) {
        if (randomCount < 4) return
        position++
    }
}

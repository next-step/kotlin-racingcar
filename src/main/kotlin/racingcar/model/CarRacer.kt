package racingcar.model

/**
 * 자동차 경주자
 */
class CarRacer(position: Int = 0) {

    var position: Int = position
        private set

    fun moveTo(randomCount: Int) {
        if (randomCount < 4) return
        position++
    }

    companion object {
        fun ofCarRacer(racer: CarRacer): CarRacer {
            return CarRacer(racer.position)
        }
    }
}

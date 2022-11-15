package racingcar.model

/**
 * 자동차 경주자
 */
class CarRacer {

    var path: String = ""
        private set

    fun moveTo(position: Int): String {
        if (position < 4) return ""
        path += CHARACTER_MOVE
        return path
    }

    companion object {
        const val CHARACTER_MOVE = "-"
    }
}

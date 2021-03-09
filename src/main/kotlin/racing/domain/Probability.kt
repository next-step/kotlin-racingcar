package racing.domain

open class Probability {

    open fun getProbability(): Int {
        return (MIN_VALUE..MAX_VALUE).random()
    }

    fun canGo(): Boolean {
        return getProbability() >= GO_LIMIT
    }

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9
        private const val GO_LIMIT = 4
    }
}

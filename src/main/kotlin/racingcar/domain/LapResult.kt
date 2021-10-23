package racingcar.domain

data class LapResult(val carName: String, val movedDistance: Int) {
    fun isNotWinner(longestMovedDistance: Int) = movedDistance < longestMovedDistance

    fun isNewLongestMovedDistance(longestMovedDistance: Int) = movedDistance > longestMovedDistance

    override fun toString(): String = "$carName : ${getMovedDistanceExpression(movedDistance)}"

    private fun getMovedDistanceExpression(distance: Int) = "-".repeat(distance)
}

package racingcar.domain

data class LapResult(val carName: String, val movedDistance: Int) {
    override fun toString(): String = "$carName : ${getMovedDistanceExpression(movedDistance)}"

    fun isNotWinner(longestMovedDistance: Int) = movedDistance < longestMovedDistance

    fun isNewLongestMovedDistance(longestMovedDistance: Int) = movedDistance > longestMovedDistance

    private fun getMovedDistanceExpression(distance: Int) = "-".repeat(distance)
}

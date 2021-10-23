package racingcar

data class LapResult(val carName: String, val movedDistance: Int) {
    fun isNotWinner(longestMovedDistance: Int) = movedDistance < longestMovedDistance

    fun isNewLongestMovedDistance(longestMovedDistance: Int) = movedDistance > longestMovedDistance
}

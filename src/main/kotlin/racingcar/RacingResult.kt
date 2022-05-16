package racingcar

class RacingResult(val round: Int, val distancesMoved: List<String>) {

    companion object {
        fun of(round: Int, cars: Cars): RacingResult {
            return RacingResult(round, cars.distancesMoved())
        }

        private const val MOVED_SYMBOL = "-"
    }
}

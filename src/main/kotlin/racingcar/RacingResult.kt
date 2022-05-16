package racingcar

class RacingResult(val round: Int, val values: List<String>) {

    companion object {
        fun of(round: Int, cars: Cars): RacingResult {
            return RacingResult(round, cars.values.map { MOVED_SYMBOL.repeat(it.distanceMoved) })
        }

        const val MOVED_SYMBOL = "-"
    }
}

package racingcar

class RacingResult(val round : Int, val values : List<Int>) {

    companion object {
        fun of(round: Int, cars: Cars) : RacingResult {
            return RacingResult(round, cars.values.map { it.distanceMoved })
        }
    }
}

package racingcar

class RacingResult(val round: Int, val distancesMoved: List<Int>) {

    companion object {
        fun of(round: Int, cars: Cars): RacingResult {
            return RacingResult(round, cars.distancesMoved())
        }
    }
}

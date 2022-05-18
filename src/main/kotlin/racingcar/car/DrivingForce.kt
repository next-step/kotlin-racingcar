package racingcar.car

enum class DrivingForce(private val range: IntRange, private val point: Int) {
    STOP(0..3, 0),
    FORWARD1(4..9, 1);

    companion object {
        private const val pointByErrorMessage = "동력 포인트 범위를 벗어난 값입니다."

        fun pointBy(i: Int): Int {
            if (STOP.range.contains(i)) return STOP.point
            if (FORWARD1.range.contains(i)) return FORWARD1.point
            throw IllegalAccessException("$pointByErrorMessage [$i]")
        }
    }
}

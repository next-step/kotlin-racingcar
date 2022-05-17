package racingcar.car

enum class DrivingForce(val range: IntRange, val point: Int) {
    RANGE0(0..3, 0),
    RANGE1(4..9, 1);

    companion object {
        private const val pointByErrorMessage = "동력 포인트 범위를 벗어난 값입니다."

        fun pointBy(i: Int): Int {
            if (RANGE0.range.contains(i)) return RANGE0.point
            if (RANGE1.range.contains(i)) return RANGE1.point
            throw IllegalAccessException("$pointByErrorMessage [$i]")
        }
    }
}

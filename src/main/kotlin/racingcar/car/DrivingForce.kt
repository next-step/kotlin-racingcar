package racingcar.car

object DrivingForce {
    private val range0 = (0..3)
    private val range1 = (4..9)
    private const val pointByErrorMessage = "동력 포인트 범위를 벗어난 값입니다."

    fun pointBy(i: Int): Int {
        if (range0.contains(i)) return 0
        if (range1.contains(i)) return 1
        throw IllegalAccessException("$pointByErrorMessage [$i]")
    }
}

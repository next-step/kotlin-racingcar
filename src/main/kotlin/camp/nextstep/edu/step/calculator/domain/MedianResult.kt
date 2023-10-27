package camp.nextstep.edu.step.calculator.domain


@JvmInline
value class MedianResult private constructor(
    val medianResult: Long
) {
    companion object {
        fun of(medianResult: Long): MedianResult {
            return MedianResult(medianResult)
        }
    }

}

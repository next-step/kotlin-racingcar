package camp.nextstep.edu.step.calculator.domain

@JvmInline
value class FinalResult private constructor(
    val calculationResult: Long
) {
    companion object {
        fun of(medianResult: MedianResult): FinalResult {
            return FinalResult(medianResult.medianResult)
        }
    }

}

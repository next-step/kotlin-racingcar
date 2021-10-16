package calculator.domain.vo

@JvmInline
value class Term(val value: Double) {
    constructor(input: Int) : this(input.toDouble())
    constructor(input: Long) : this(input.toDouble())
    constructor(input: String) : this(
        input.toDoubleOrNull()
            ?: throw IllegalArgumentException("잘못된 숫자가 입력되었습니다.")
    )
}

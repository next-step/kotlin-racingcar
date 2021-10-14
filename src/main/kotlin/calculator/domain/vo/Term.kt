package calculator.domain.vo

@JvmInline
value class Term(private val _value: Double?) {
    val value: Double
        get() {
            require(_value != null) { "잘못된 숫자가 입력되었습니다." }
            return _value
        }

    constructor(input: String) : this(input.toDoubleOrNull())
    constructor(input: Long) : this(input.toDouble())
    constructor(input: Int) : this(input.toDouble())
}

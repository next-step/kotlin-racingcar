package calculator

data class Number private constructor(
    private val value: Int
){
    companion object {
        fun from(value: String): Number = Number(value.toInt())
    }
}

package calculator

data class Number constructor(
    val value: Int
){
    companion object {
        fun from(value: String): Number = Number(value.toInt())
    }
}

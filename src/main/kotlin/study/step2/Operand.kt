package study.step2

class Operand private constructor(val value: Int) {
    companion object {
        fun of(value: String): Operand {
            return Operand(value.toInt())
        }
    }
}

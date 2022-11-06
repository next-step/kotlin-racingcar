package step2.calculator.system.component

import kotlin.jvm.Throws

data class Numeric(
    val value: Double
) : Component {

    companion object {
        @Throws(NumberFormatException::class)
        @JvmStatic
        fun from(input: String): Numeric {
            return Numeric(input.toDouble())
        }

        @JvmStatic
        fun isNumeric(input: String): Boolean {
            return try {
                input.toDouble()
                true
            } catch (e: NumberFormatException) {
                false
            }
        }
    }
}

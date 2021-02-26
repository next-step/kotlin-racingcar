package calculation

abstract class MathNumber : Number() {
    protected abstract val value: Number

    override fun toByte() = value.toByte()

    override fun toChar() = value.toChar()

    override fun toDouble() = value.toDouble()

    override fun toFloat() = value.toFloat()

    override fun toInt() = value.toInt()

    override fun toLong() = value.toLong()

    override fun toShort() = value.toShort()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Number) return false
        if (value != other) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return value.toString()
    }
}

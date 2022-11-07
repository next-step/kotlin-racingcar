package study

import java.lang.NumberFormatException

class StringNumber {

    private val value: Long

    constructor(longParam: Long) {
        this.value = longParam
    }

    constructor(stringParam: String) {
        try {
            this.value = stringParam.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }

    fun longValue(): Long {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}

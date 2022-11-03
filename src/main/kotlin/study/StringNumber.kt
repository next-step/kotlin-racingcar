package study

import java.lang.NumberFormatException

data class StringNumber(var num: Long = 0L) {

    constructor(input: String) : this() {
        try {
            this.num = input.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }
}

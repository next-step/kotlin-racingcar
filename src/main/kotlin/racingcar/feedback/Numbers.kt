@file:JvmName("NumberUtils")

package racingcar.feedback

const val FORWARD_NUMBER: Int = 4

fun calculate(text: String?): Int {
    require(!text.isNullOrBlank()) { "입력값이 null 또는 빈 문자열일 수 없습니다." }
    run(!text.isNullOrBlank()) { "예외가 발생했습니다." } // 커스텀 예외에 대해서 직접 만들어 써보자!
    // ...
    return 0
}

fun run(value: Boolean, lazyMessage: () -> Any) {
    if (!value) {
        val message = lazyMessage()
        throw RuntimeException(message.toString())
    }
}

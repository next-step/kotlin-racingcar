package study.racingcar.step4.utils

class StringUtil {
    companion object {
        fun splitToListString(value: String?, delimiters: String): List<String> {
            return value?.split(delimiters) ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
        }
    }
}

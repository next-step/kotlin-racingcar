package study.racingcar.step4.utils

class IntUtil {

    companion object {
        fun convertToInt(value: String?): Int {
            return value?.toInt() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
        }
    }
}

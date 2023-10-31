package study.racingcar.application

/**
 * 게임 반복 횟수를 나타내는 숫자를 입력받는 객체이다.
 * */
data class Number(val value: String) {

    /**
     * 입력으로 문자열을 받고 1 이상의 정수형의 숫자인지 검증 후 Int 로 변환해서 반환한다.
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    fun getProperFormatNumber(): Int {
        val num = try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력 값이 정수형의 숫자가 아닙니다. 숫자를 입력해주세요.")
        }

        if (num < 1) {
            throw IllegalArgumentException("입력 값을 확인해주세요. 1 이상의 숫자만 입력 가능합니다.")
        }

        return num
    }
}

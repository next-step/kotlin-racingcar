package study.racingcar.application

/**
 * 게임에 참여하는 자동차 이름을 입력받는 객체이다,
 * */
class CarNames(private val value: String) {

    /**
     * 입력받은 문자열이 유효한지 검증한다.
     *    - 이름은 중복될 수 없다. (사용자 정의)
     *    - 자동차 이름의 길이는 5자 이하이어야 한다.
     *    - 자동차 대수와 시도 횟수는 1 이상이어야 한다. (사용자 정의)
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    fun getProperFormatCarNames(): List<String> {
        val carNames = value.split(",")
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.")
        }

        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름의 길이는 5자 이하이어야 합니다.")
        }

        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }

        return carNames
    }
}
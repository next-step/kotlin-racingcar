package study.racingcar.application

import study.racingcar.dto.CarName
import study.racingcar.dto.CarNames

/**
 * 문자열 프로퍼티를 받고, 게임에 참여하는 자동차 이름을 입력받는 객체이다.
 * */
class CarNameParser(private val name: String) {    // 주생성자
    private val names: List<String> = name.split(",") // 프로퍼티 초기화
    private val carNames = CarNames(names.map { CarName(it) }) // 프로퍼티 초기화

    init {
        require(validateProperInput(names))
    }

    /**
     * 입력받은 문자열이 유효한지 검증한다.
     *    - 이름은 중복될 수 없다. (사용자 정의)
     *    - 자동차 대수와 시도 횟수는 1 이상이어야 한다. (사용자 정의)
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    private fun validateProperInput(values: List<String>): Boolean {
        if (values.isEmpty()) {
            throw IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.")
        }

        if (values.size != values.distinct().size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }

        return true
    }

    fun getCarNames(): CarNames {
        return carNames
    }
}

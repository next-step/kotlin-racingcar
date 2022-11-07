package study.step4.view

import study.step2.isInt
import study.step4.util.CAR_NAME_DELIMITERS
import study.step4.view.InputGenerator.convertRacingCarNamesList

object InputValid {
    fun racingCarNameValid(racingCarNames: String?) {
        requireNotNull(racingCarNames) { "자동차 이름을 입력해 주세요" }
        require(racingCarNames.trim().isNotEmpty()) { "자동차 이름은 공백일 수 없습니다" }
        require(!racingCarNames.trim().endsWith(CAR_NAME_DELIMITERS)) { "마자막 문자는 쉽표(,) 일수 없습니다" }

        val racingCarNamesList = convertRacingCarNamesList(racingCarNames)
        racingCarNamesList.forEach {
            require(it.trim().length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다" }
        }
        val distinctRacingCarNamesList = racingCarNamesList.distinct()
        require(racingCarNamesList.size == distinctRacingCarNamesList.size) { "중복된 이름을 사용할 수 없습니다" }
    }

    fun repeatTimeValid(repeatTime: String?) {
        requireNotNull(repeatTime) { "숫자를 입력해야 합니다" }
        require(repeatTime.isInt()) { "숫자만 입력 가능합니다" }
    }
}

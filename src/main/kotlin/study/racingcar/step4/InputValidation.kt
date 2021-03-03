package study.racingcar.step4

class InputValidation {

    private val NAME_MAX_LENGTH = 5

    fun validationCarNameLength(carNameList: List<String>) {
        carNameList.forEach { name -> require(name.length <= NAME_MAX_LENGTH) { "자동차 이름은 ${NAME_MAX_LENGTH}자를 초과할 수 없다." } }
    }
}

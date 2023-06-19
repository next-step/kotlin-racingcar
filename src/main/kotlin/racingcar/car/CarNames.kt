package racingcar.car

class CarNames(val names: List<String>) {

    init {
        require(names.isNotEmpty()) { "자동차 이름은 1개 이상이어야 합니다." }
        require(names.all { it.isNotBlank() }) { "자동차 이름은 공백이 아니어야 합니다." }
        require(names.distinct().size == names.size) { "자동차 이름은 중복되지 않아야 합니다." }
    }

}

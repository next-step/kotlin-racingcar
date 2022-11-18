package racingcar.input

data class Racers(private val racers: String) {
    val value = racers.split(",")

    init {
        require(racers.isNotEmpty()) { "자동차 이름은 1글자 이상이어야 합니다." }
        require(racers.contains(",")) { "자동차 이름은 쉼표(,)로 구분해 주세요." }
        require(value.size == value.distinct().size) { "자동차 이름은 중복될 수 없습니다." }
    }
}

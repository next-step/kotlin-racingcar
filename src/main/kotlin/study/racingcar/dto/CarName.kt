package study.racingcar.dto

/**
 * 게임에 참여하는 자동차 이름 객체이다.
 * */
@JvmInline
value class CarName(private val name: String) {
    init {
        require(name.length <= 5) { "자동차 이름의 길이는 5자 이하이어야 합니다." }
        require(name.isNotBlank()) { "자동차 이름은 공백이 될 수 없습니다." }
    }

    override fun toString(): String {
        return name
    }
}
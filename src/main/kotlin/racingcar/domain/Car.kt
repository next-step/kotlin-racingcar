package racingcar.domain

data class Car(
    val name: String,
    val position: Int = 0
) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 ${MAX_NAME_LENGTH}자를 초과 할 수 없습니다." }
    }

    fun move(foreword: Int): Car =
        if (foreword >= FOREWORD_CRITERIA) this.copy(position = this.position.inc())
        else this

    companion object {
        private const val FOREWORD_CRITERIA = 4
        private const val MAX_NAME_LENGTH = 5
    }
}

package racingcar.model

data class TryNumber(
    val number: Int
) {
    init {
        require(number > 0) { "적어도 한번 이상의 시도를 해주세요." }
    }
}

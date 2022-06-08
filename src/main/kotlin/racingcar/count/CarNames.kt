package racingcar.count

class CarNames(input: String, minCount: Int = 2) {
    val value = input.split(',').map { it.trim() }.filter { it.isNotBlank() }
    private val count: Int = value.size
    private val uniqueCount: Int = value.groupBy { it }.keys.size

    init {
        require(minCount >= 1) { "최소 자동차 수는 1 이상이어야 합니다." }
        require(count >= minCount) { "자동차 이름이 최소 $minCount 개 이상 필요합니다." }
        require(count == uniqueCount) { "중복된 자동차 이름을 사용할 수 없습니다." }
    }

    companion object {
        const val inputMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    }
}

package step4.racingcar.racingcar

object InputViewValidator {
    fun racers(racers: List<String>) {
        require(!racers.any { it.length > 5 }) { "입력된 선수의 이름이 5자 이상인 선수가 있습니다." }
    }
}

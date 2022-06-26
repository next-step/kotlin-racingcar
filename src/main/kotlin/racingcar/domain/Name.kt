package racingcar.domain

import kotlin.random.Random

private val chars = (('A'..'Z') + ('0'..'9'))
private fun getDefaultName() = (0..4)
    .map { chars[Random.nextInt(chars.size)] }
    .joinToString("")

class Name(val value: String = getDefaultName()) {

    init {
        require(value.length in 1..5) { "자동차 이름은 1자 이상이고, 5자를 초과할 수 없습니다." }
    }
}

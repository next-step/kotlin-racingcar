package racingcar.view

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import racingcar.domain.ParticipateCarName

internal class ParticipateCarNameTest : FunSpec({
    context("경주에 참여하는 자동차 이름은 최대 5자까지 가능하다.") {
        withData(
            "a", "ab", "abc", "abcd", "abcde"
        ) { data ->
            shouldNotThrowAny { ParticipateCarName(data) }
        }
    }

    context("경주에 참여하는 자동차 이름이 6자 이상일 경우 예외를 던진다.") {
        withData(
            "abcdef", "abcdefg"
        ) { data ->
            shouldThrow<IllegalArgumentException> { ParticipateCarName(data) }
        }
    }
})

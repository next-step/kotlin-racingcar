package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class NicknameTest : ExpectSpec({

    expect("빈문자열을 입력하면 예외가 발생한다.") {
        val exception = shouldThrow<IllegalArgumentException> {
            Nickname("")
        }

        exception.message shouldBe "닉네임은 1자 이상 5자 이하만 가능합니다."
    }

    expect("5글자가 넘으면 예외가 발생한다.") {
        val exception = shouldThrow<IllegalArgumentException> {
            Nickname("123456")
        }

        exception.message shouldBe "닉네임은 1자 이상 5자 이하만 가능합니다."
    }

    expect("woody 를 입력하면 Nickname 객체를 생성한다") {
        val nickname = Nickname("woody")

        nickname.value shouldBe "woody"
    }
})

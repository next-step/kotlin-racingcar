package study.racinggame.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class ParticipantTest : StringSpec({
    "참가자 생성 시, 공백 문자열이 입력 되면 오류가 발생 한다." {
        // when & then
        shouldThrow<InvalidParticipantNameException> { Participant("") }
        shouldThrow<InvalidParticipantNameException> { Participant(" ") }
    }

    "참가자 생성 시, 이름이 5글자를 초과 하면 오류가 발생 한다." {
        // when & then
        shouldNotThrow<InvalidParticipantNameException> { Participant("12345") }
        shouldThrow<InvalidParticipantNameException> { Participant("123456") }
    }
})

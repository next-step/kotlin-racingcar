package me.devyonghee.racingcar

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

@DisplayName("사람")
class PersonTest : StringSpec({

    "named arguments 로 함수 호출 가독성을 향상" {
        // given
        val yongheeName = "한용희"
        val yongheeAge = 20
        val yongheeNickname = "용용"
        // when
        val yonghee = Person(name = yongheeName, age = yongheeAge, nickname = yongheeNickname)
        // then
        assertSoftly(yonghee) {
            name shouldBe yongheeName
            age shouldBe yongheeAge
            nickname shouldBe yongheeNickname
        }
    }

    "nullable type 을 명시할 수 있음" {
        // given
        val yonghee = Person("한용희", null, null)
        // when & then
        assertSoftly(yonghee) {
            name shouldBe "한용희"
            age.shouldBeNull()
            nickname.shouldBeNull()
        }
    }

    "기본 인자로 메소드를 호출할 수 있음" {
        // given
        val yonghee = Person("한용희")
        // when & then
        assertSoftly(yonghee) {
            name shouldBe "한용희"
            age.shouldBeNull()
            nickname.shouldBeNull()
        }
    }

    "data classe 는 hashCode equals 를 자동 생성" {
        // given
        val yonghee = Person("한용희", 20)
        // when & then
        yonghee shouldBe Person("한용희", 20)
    }
})

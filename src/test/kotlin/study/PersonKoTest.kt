package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import java.util.StringTokenizer

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person("shinyoung Kim", 30, "rolroralra")
        person.name shouldBe "shinyoung Kim"
        person.age shouldBe 30
        person.nickname shouldBe "rolroralra"
    }

    "널 타입" {
        val person = Person("shinyoung Kim", 20, null)
        person.nickname.shouldBeNull()
        assertThat(person.nickname).isNull()
    }

    "기본인자" {
        val person = Person("shinyoung Kim", 30)
        person.name shouldBe "shinyoung Kim"
        person.age shouldBe 30
        person.nickname shouldBe "nickname"
    }

    "데이터 클래스" {
        val person = Person("shinyoung Kim", 30)
        val person2 = Person("shinyoung Kim", 30)

        person shouldBe person2
    }

    "test" {
        println(StringTokenizer("1  + 2 +  3", " ").toList())
        println("1  +  2  +  3".split(" ").filter { it.isNotBlank() })
    }
})

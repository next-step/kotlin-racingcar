import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import java_convert_kotlin.Person

class PersonTest : FunSpec ({

    test("이름 붙인 인자") {
        val people = listOf(
            Person("박민영", 29, "찰리"),
            Person("박민영", 29, nickname = "찰리"),
            Person(name = "박민영", nickname = "찰리", age = 29)
        )

        people.shouldForAll {
            it.name shouldBe "박민영"
            it.nickname shouldBe "찰리"
        }
    }
})

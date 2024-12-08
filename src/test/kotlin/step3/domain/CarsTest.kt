package step3.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest : StringSpec({
    lateinit var dummyPolicy: MovePolicy

    beforeSpec {
        dummyPolicy =
            object : MovePolicy {
                override fun shouldMove(): Boolean = true
            }
    }

    "이창환 1등임을 판별한다" {
        val cars =
            Cars(
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이민수", location = 1, movePolicy = dummyPolicy),
                Car(name = "송상현", location = 2, movePolicy = dummyPolicy),
            )

        cars.getWinner().sorted() shouldBe listOf("이창환").sorted()
    }

    "이창환 이민수 공동 1등임을 판별한다" {
        val cars =
            Cars(
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이민수", location = 3, movePolicy = dummyPolicy),
                Car(name = "송상현", location = 2, movePolicy = dummyPolicy),
            )

        cars.getWinner().sorted() shouldBe listOf("이민수", "이창환").sorted()
    }

    "이창환 이창환 이민수 공동 1등임을 판별한다" {
        val cars =
            Cars(
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이민수", location = 3, movePolicy = dummyPolicy),
                Car(name = "송상현", location = 2, movePolicy = dummyPolicy),
            )

        cars.getWinner().sorted() shouldBe listOf("이창환", "이민수", "이창환").sorted()
    }
}) {
    lateinit var dummyPolicy: MovePolicy

    @BeforeEach
    fun setUp() {
        dummyPolicy =
            object : MovePolicy {
                override fun shouldMove(): Boolean = true
            }
    }

    @Test
    fun `이창환 1등임을 판별한다`() {
        val cars =
            Cars(
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이민수", location = 1, movePolicy = dummyPolicy),
                Car(name = "송상현", location = 2, movePolicy = dummyPolicy),
            )

        val winner = cars.getWinner().sorted()
        assertEquals(listOf("이창환").sorted(), winner)
    }

    @Test
    fun `이창환 이민수 공동 1등임을 판별한다`() {
        val cars =
            Cars(
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이민수", location = 3, movePolicy = dummyPolicy),
                Car(name = "송상현", location = 2, movePolicy = dummyPolicy),
            )

        val winner = cars.getWinner().sorted()
        assertEquals(listOf("이민수", "이창환").sorted(), winner)
    }

    @Test
    fun `이창환 이창환 이민수 공동 1등임을 판별한다`() {
        val cars =
            Cars(
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이창환", location = 3, movePolicy = dummyPolicy),
                Car(name = "이민수", location = 3, movePolicy = dummyPolicy),
                Car(name = "송상현", location = 2, movePolicy = dummyPolicy),
            )

        val winner = cars.getWinner().sorted()
        assertEquals(listOf("이창환", "이민수", "이창환").sorted(), winner)
    }
}

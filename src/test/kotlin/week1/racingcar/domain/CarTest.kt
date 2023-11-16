package week1.racingcar.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CarTest {
    @Test
    fun `자동차 객체가 정상적으로 생성되었는지 확인`() {
        val car1 = Car("James")
        car1.name shouldBe "James"
    }

    @Test
    fun `자동차 객체 생성 정보의 유효성 확인`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("Thomas")
        }
        assertThrows(IllegalArgumentException::class.java) {
            Car("Tho mas")
        }
    }

    @ParameterizedTest
    @MethodSource("makeNumberMovePair")
    fun `한 턴 진행`(numberMovePair: Pair<Int, Int>) {
        val number = numberMovePair.first
        val expectedMileage = numberMovePair.second
        val car = Car("K5")
        car.moveOrNotByNum(number)
        assertThat(car.currentMileage).isEqualTo(expectedMileage)
    }

    @Test
    fun `주행거리 비교`() {
        val car = Car("EV6")
        car.isSameMileage(100) shouldBe false
    }

    companion object {
        @JvmStatic
        fun makeNumberMovePair() = listOf(
            0 to 0,
            1 to 0,
            2 to 0,
            3 to 0,
            4 to 0,
            5 to 1,
            6 to 1,
            7 to 1,
            8 to 1,
            9 to 1,
        )
    }
}

package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    @DisplayName("이동은 shouldMove가 참일 때 위치를 증가시켜야 한다")
    fun `move should increment position when shouldMove is true`() {
        val car = Car(CarName("Car1"))
        car.move(true)
        assertEquals(1, car.position)
    }

    @Test
    @DisplayName("이동은 shouldMove가 거짓일 때 위치를 증가시키지 않아야 한다")
    fun `move should not increment position when shouldMove is false`() {
        val car = Car(CarName("Car2"))
        car.move(false)
        assertEquals(0, car.position)
    }

    @Test
    @DisplayName("자동차 이름이 1자 이상 5자 이하일 때 객체 생성이 성공해야 한다")
    fun `should create CarName object when name length is between 1 and 5`() {
        val validNames = listOf("1", "12", "123", "1234", "12345")

        validNames.forEach { name ->
            val carName = CarName(name)
            assertEquals(name, carName.name)
        }
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 때 예외를 던져야 한다")
    fun `should throw exception when name is blank`() {
        assertThrows<IllegalArgumentException> {
            CarName("")
        }
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외를 던져야 한다.")
    fun `should throw exception when car name is longer than 5 characters`() {
        assertThrows<IllegalArgumentException> {
            Car(CarName("123456"))
        }
    }
}

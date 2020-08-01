package com.nextstep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `입력된 랜덤 숫자가 4보다 크거나 같으면 이동이 가능하다`() {
        val car = Car("abc")

        car.move(4)

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `입력된 랜덤 숫자가 4보다 작으면 이동이 불가능하다`() {
        val car = Car("abc")

        car.move(3)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `이름이 비어 있으면 에러가 발생한다`() {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) {
            Car("")
        }
    }

    @Test
    fun `이름이 5자 이상이라면 에러가 발생한다`() {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) {
            Car("123456")
        }
    }

    @Test
    fun `사용자가 입력한 이름과 position이 0인 car를 만든다`() {
        val name = "van"
        val car = Car(name)

        assertThat(car.getName()).isEqualTo(name)
        assertThat(car.position).isEqualTo(0)
    }
}

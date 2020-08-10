package com.nextstep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `입력된 랜덤 숫자가 4보다 크거나 같으면 이동이 가능하다`(randomNumber: Int) {
        val car = Car("abc")

        car.move(randomNumber)

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc"])
    fun `입력된 랜덤 숫자가 4보다 작으면 이동이 불가능하다`(name: String) {
        val car = Car(name)

        car.move(3)

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @EmptySource
    fun `이름이 비어 있으면 에러가 발생한다`(name: String) {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456"])
    fun `이름이 5자 이상이라면 에러가 발생한다`(name: String) {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["van"])
    fun `사용자가 입력한 이름과 position이 0인 car를 만든다`(name: String) {
        val car = Car(name)

        assertThat(car.getName()).isEqualTo(name)
        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["van"])
    internal fun `포지션이 일치하는지 테스트`(name: String) {
        val car = Car(name)

        car.move(5)
        car.move(7)
        car.move(9)

        assertThat(car.isMatchedPosition(3)).isTrue()
    }

    @Test
    internal fun `position을 입력하여 Car를 만들 수 있다`() {
        val car = Car("van", 10)

        assertThat(car.position).isEqualTo(10)
    }
}

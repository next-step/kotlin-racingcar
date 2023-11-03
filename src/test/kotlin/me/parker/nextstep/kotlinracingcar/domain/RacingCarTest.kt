package me.parker.nextstep.kotlinracingcar.domain

import me.parker.nextstep.kotlinracingcar.domain.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.domain.rule.TestRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {

    @Test
    fun `자동차 생성 - 최초 위치가 0인지 검증`() {
        val name = "crong"
        val racingCar = RacingCar(name, RandomRacingGameMoveRule())

        assertThat(racingCar).isNotNull
        assertThat(racingCar.name).isEqualTo(name)
        assertThat(racingCar.position).isEqualTo(0)
    }

    @Test
    fun `자동차 앞으로 이동`() {
        val racingCar = RacingCar("crong", TestRacingGameMoveRule(true))

        racingCar.moveForward()

        assertThat(racingCar.position).isEqualTo(1)
    }

    @Test
    fun `자동차 앞으로 이동할 수 없음`() {
        val racingCar = RacingCar("crong", TestRacingGameMoveRule(false))

        racingCar.moveForward()

        assertThat(racingCar.position).isEqualTo(0)
    }

    @Test
    fun `copy시 같은 정보의 다른 객체를 반환`() {
        val racingCar = RacingCar("crong", TestRacingGameMoveRule(true))

        val copiedRacingCar = racingCar.copy()

        assertThat(racingCar).isNotSameAs(copiedRacingCar)
        assertThat(racingCar.name).isEqualTo(copiedRacingCar.name)
        assertThat(racingCar.position).isEqualTo(copiedRacingCar.position)

        racingCar.moveForward()

        val copiedRacingCar2 = racingCar.copy()

        assertThat(racingCar).isNotSameAs(copiedRacingCar2)
        assertThat(racingCar.position).isEqualTo(copiedRacingCar2.position)
        assertThat(copiedRacingCar).isNotSameAs(copiedRacingCar2)
        assertThat(copiedRacingCar.position + 1).isEqualTo(copiedRacingCar2.position)
    }

    @ParameterizedTest
    @EmptySource
    fun `자동차 이름은 빈값 불가`(input: String) {
        assertThatThrownBy { RacingCar(input, RandomRacingGameMoveRule()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 공백일 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["aaaaaa", " aaaaa", "aa__aa", "aaa123"])
    fun `자동차 이름은 5자를 초과 불가`(input: String) {
        assertThatThrownBy { RacingCar(input, RandomRacingGameMoveRule()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 1~5자만 가능합니다.")
    }
}
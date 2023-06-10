package com.racing.step3.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarGameServiceTest {
    @Test
    fun `주어진 숫자만큼 자동차 객체를 생성`() {
        // given
        val totalCarNum = 10

        // when
        val createCarList = CarGameService.createCarList(totalCarNum)

        // then
        assertThat(createCarList.size).isEqualTo(totalCarNum)
    }

    @Test
    fun `자동차 객체 이동 확인`() {
        // given
        val fixedMoveCarStrategy: () -> Int = { 4 }
        val totalCarNum = 3
        var createdCarList = CarGameService.createCarList(totalCarNum)

        // when
        createdCarList = CarGameService.moveCar(createdCarList, fixedMoveCarStrategy)

        // then
        assertThat(createdCarList.size).isEqualTo(totalCarNum)
        createdCarList.forEach {
            assertThat(it.position).isEqualTo(1)
        }
    }
}

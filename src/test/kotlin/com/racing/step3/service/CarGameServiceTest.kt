package com.racing.step3.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarGameServiceTest {
    @Test
    fun `주어진 숫자만큼 자동차 객체를 생성`() {
        // given
        val totalCarNum = 10

        // when
        val createCarList = CarGameService.createCarList(totalCarNum)

        // then
        Assertions.assertThat(createCarList.size).isEqualTo(totalCarNum)
    }

    @Test
    fun `자동차를 이동시키는 로직`() {
        // given
        val totalCarNum = 10
        val stage = 2
        // when
        val createCarList = CarGameService.createCarList(totalCarNum)

        // then
        Assertions.assertThat(createCarList.size).isEqualTo(totalCarNum)
    }
}

package racingCar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `check input count`() { // null check / 1이상인지 체크 => 초기화하는 함수 및 예외처리
    }

    @Test
    fun `check input randomNumber`(randomNumber: Int) { // 0보다 작은 값, 9보다 큰 값 입력시  => 예외처리

        assertTrue { randomNumber >= 0 }
        assertTrue { randomNumber < 10 }
    }

    @Test
    fun `check car running state`() { // 4이상이면 전진하는 모습 => 경주를 하는 메소드
    }

    @Test
    fun `check car stop state`() { // 4미만이면 정지하는 모습 => 스탑 메소드?
    }

    @Test
    fun `check car current distance`() { // 자동차의 현재 위치 확인?
    }

    @Test
    fun `check output`() { // 출력 => 출력 메소드
    }
}

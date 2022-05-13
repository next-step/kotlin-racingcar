package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RaceTest {
    /*
    1. 차량 객체 구현
      1-1. 차량의 위치인 position 을 프로퍼티로 가짐.
      1-2. 화면에 출력하는 toString 을 함수로 가짐.
      1-3. 이동을 위한 move 를 함수로 가짐.

    2. MoveDecider 객체 구현
      2-1. Random 객체를 파라미터로 받아 한자리 수를 돌려주는 getRandomDigit 메서드 구현
      2-2. randomDigit을 파라미터로 받아 이동 여부를 판단하는 canMove 메서드 구현

    3. Race 객체 구현
      3-1. 차량수와 시도수를 프로퍼티로 가짐
      3-2. 차량과 현재 시도 횟수를 프로퍼티로 가짐
      3-3. next 함수가 호출될 때 마다 모든 차량들을 랜덤하게 이동시킴 (이동, 체류)
      3-4. isFinished 함수를 통해 레이싱이 완료되었는지 점검

    4. RaceRunner 객체 구현
      4-1. InputView 로 부터 차량수, 시도수 가져옴
      4-2. Race 수행 (중간중간 OutputView 로 결과 출력)
     */

    @Test
    fun `test constructor`() {
        val race = Race(3, 5)
        Assertions.assertThat(race.cars.size).isEqualTo(3)
    }

    @Test
    fun `test isFinished`() {
        val race = Race(3, 2)
        Assertions.assertThat(race.isFinished()).isEqualTo(false)
        Assertions.assertThat(race.next().isFinished()).isEqualTo(true)
    }

    @Test
    fun `test next`() {
        val tries = 1000
        val race = (0..99).fold(Race(5, tries)) { r, _ -> r.next() }
        Assertions.assertThat(race.cars.find { car -> car.position > 10 }).isNotNull
    }
}

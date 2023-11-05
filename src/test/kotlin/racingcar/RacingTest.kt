package racingcar

import io.kotest.core.spec.style.FunSpec
import racingcar.car.RacingCar

class RacingTest: FunSpec({
    // SystemOutExtension을 사용하여 콘솔 출력을 캡처
    context("racing 통합 테스트") {
      val racing = Racing { RacingCar() }
      racing.doRacing(3, 5)
  }
})
package study.step3.model

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat

 class CarTest : StringSpec({

     "주어진 자동차를, 전진하면, 위치가 1 증가한다  "{
         val car = Car()
         val beforeLocation = car.location()
         car.advance()
         val afterLocation = car.location()

         assertThat(afterLocation - beforeLocation).isOne()
     }
 })

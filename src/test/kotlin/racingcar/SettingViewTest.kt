package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class SettingViewTest : BehaviorSpec({

    given("입력값이 주어지지 않은 상태") {
        val numberOfCars = null
        val numberOfLabs = null

        `when`("설정을 시도하면") {

            then("IllegalArgumentException(입력값이 null 혹은 공백일 수 없습니다)을 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("입력값이 null 혹은 공백일 수 없습니다") {
                    SettingView().setUp(numberOfCars, numberOfLabs)
                }
            }
        }
    }

    given("숫자가 아닌 문자열이 주어진 상태") {
        val numberOfCars = "1"
        val numberOfLabs = "text"

        `when`("설정을 시도하면") {
            then("IllegalArgumentException(입력된 문자는 정수여야 합니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("입력된 문자는 정수여야 합니다") {
                    SettingView().setUp(numberOfCars, numberOfLabs)
                }
            }
        }
    }

    given("실수 문자열이 주어진 상태") {
        val numberOfCars = "1.2"
        val numberOfLabs = "2"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(입력된 문자는 정수여야 합니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("입력된 문자는 정수여야 합니다") {
                    SettingView().setUp(numberOfCars, numberOfLabs)
                }
            }
        }
    }

    given("1보다 작은 값의 정수 문자열이 주어진 상태") {
        val numberOfCars = "2"
        val numberOfLabs = "-1"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(1보다 작은 정수를 입력할 수 없습니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("1보다 작은 정수를 입력할 수 없습니다") {
                    SettingView().setUp(numberOfCars, numberOfLabs)
                }
            }
        }
    }

    given("자동차 5대와 3바퀴가 문자열로 주어진 상태") {
        val numberOfCars = "5"
        val numberOfLabs = "3"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(1보다 작은 정수를 입력할 수 없습니다) 반환한다") {
                SettingView().setUp(numberOfCars, numberOfLabs) shouldBe Setting(5, 3)
            }
        }
    }

    given("자동차 5대와 3바퀴가 정수로 주어진 상태") {
        val numberOfCars = 5
        val numberOfLabs = 3
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(1보다 작은 정수를 입력할 수 없습니다) 반환한다") {
                SettingView().setUp(numberOfCars, numberOfLabs) shouldBe Setting(5, 3)
            }
        }
    }

    given("1보다 낮은 값의 정수가 주어진 상태") {
        val numberOfCars = -1
        val numberOfLabs = 3
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(1보다 작은 정수를 입력할 수 없습니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("1보다 작은 정수를 입력할 수 없습니다") {
                    SettingView().setUp(numberOfCars, numberOfLabs)
                }
            }
        }
    }
})

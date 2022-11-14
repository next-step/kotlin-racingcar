package racingcar.view

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Setting

class InputViewTest : BehaviorSpec({

    given("입력값이 주어지지 않은 상태") {
        val nameOfCars = null
        val numberOfLabs = null

        `when`("설정을 시도하면") {

            then("IllegalArgumentException(입력값이 null 혹은 공백일 수 없습니다)을 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("입력값이 null 혹은 공백일 수 없습니다") {
                    InputView().receiveSetting(nameOfCars, numberOfLabs)
                }
            }
        }
    }

    given("numberOfLabs 에 숫자가 아닌 문자열(text)이 주어진 상태") {
        val nameOfCars = "1"
        val numberOfLabs = "text"

        `when`("설정을 시도하면") {
            then("IllegalArgumentException(입력된 문자는 정수여야 합니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("입력된 문자는 정수여야 합니다") {
                    InputView().receiveSetting(nameOfCars, numberOfLabs)
                }
            }
        }
    }

    given("numberOfLabs 에 실수 문자열(1.2)이 주어진 상태") {
        val nameOfCars = "12"
        val numberOfLabs = "1.2"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(입력된 문자는 정수여야 합니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("입력된 문자는 정수여야 합니다") {
                    InputView().receiveSetting(nameOfCars, numberOfLabs)
                }
            }
        }
    }

    given("numberOfLabs 에 1보다 작은 값의 정수 문자열(-1)이 주어진 상태") {
        val nameOfCars = "2"
        val numberOfLabs = "-1"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(1보다 작은 정수를 입력할 수 없습니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("1보다 작은 정수를 입력할 수 없습니다") {
                    InputView().receiveSetting(nameOfCars, numberOfLabs)
                }
            }
        }
    }

    given("numberOfCars 에 ,로 구분되지 않은 텍스트(A)를 넣은 상태") {
        val nameOfCars = "A"
        val numberOfLabs = "3"
        `when`("설정을 시도하면") {
            then("A라는 이름을 가진 길이가 1인 이름 배열을 가진 Setting 을 반환한다") {
                val setting = InputView().receiveSetting(nameOfCars, numberOfLabs)
                setting shouldBe Setting(listOf("A"), 3)
                setting.nameOfCars.size shouldBe 1
            }
        }
    }

    given("numberOfCars 에 ,로 구분 된 각각 5글자 이하의 텍스트(홍종표,강현석,박재성)를 넣은 상태") {
        val nameOfCars = "홍종표,강현석,박재성"
        val numberOfLabs = "3"
        `when`("설정을 시도하면") {
            then("홍종표,강현석,박재성의 이름을 가진 길이가 3인 이름 배열을 가진 Setting 을 반환한다") {
                val setting = InputView().receiveSetting(nameOfCars, numberOfLabs)
                setting shouldBe Setting(listOf("홍종표", "강현석", "박재성"), 3)
            }
        }
    }

    given("numberOfCars에 5글자를 초과하는 텍스트(넥스트스텝짱)를 넣은 상태") {
        val nameOfCars = "넥스트스텝짱"
        val numberOfLabs = "3"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(자동차 이름은 다섯자를 초과할 수 없습니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 다섯자를 초과할 수 없습니다") {
                    InputView().receiveSetting(nameOfCars, numberOfLabs)
                }
            }
        }
    }

    given(",로 분리된 값이 공백이거나 빈 문자열인 상태") {
        val nameOfCars = ", ,"
        val numberOfLabs = "3"
        `when`("설정을 시도하면") {
            then("IllegalArgumentException(,로 분리된 값이 공백, 빈 문자열일 수 없습니다) 반환한다") {
                shouldThrowWithMessage<IllegalArgumentException>(",로 분리된 값이 공백, 빈 문자열일 수 없습니다") {
                    InputView().receiveSetting(nameOfCars, numberOfLabs)
                }
            }
        }
    }
})

# 자동차 경주

### 기능 요구

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 추가 사항

- [ ] 테스트 코드 작성
- [x] 모듈 형태로 작성

### 학습한 것들

- [x] 반복문, 조건문 사용
- [x] in, until 사용
- [x] sealedClass 사용

### 고민한 것들

- 객체간 협력은 어떻게 이뤄지는가? 메시지를 주고받는다고? 그게 뭔데?
    - 서로 메시지를 전달해서 역할과 책임을 위임하면서 진행한다
        - 나의 구현 : action을 dispatch하고 구독하고있는 handler를 하는 형태로 구현 -> 테스트 코드가 짜기 어려워서 삭제
        - GPT의 예제 : 주입해서 호출
            ```kotlin
            class Person(val mobile: Mobile) {
                fun tellMobileToSendMessage(message: String) {
                    mobile.sendMessage(message)
                }
            }
            
            class Mobile {
                fun sendMessage(message: String) {
                    println("Message sent: $message")
                }
            }
            
            fun main() {
                val myMobile = Mobile()
                val me = Person(myMobile)
            
                me.tellMobileToSendMessage("Hello, world!")
            }
            ```
- 사이드 이펙트가 일어나는 메서드들은 어떻게 테스트하는가
  - 상대적으로 값으로서 flow를 전달하는 함수형 프로그래밍에 비해 객체 지향 프로그래밍은 메서드에 협력으로 인한 서로 메시징을 전달하는 코드가 섞이면서 테스트가 어려워지는 것 같다.
  - GPT의 의견
    - 객체 간의 협력이 많아지면 그에 따른 테스트 코드를 작성하는 것이 복잡해질 수 있습니다. 하지만, 각 객체의 단위 테스트(Unit Test)를 먼저 진행하는 것이 중요합니다. 단위 테스트를 통해 각 객체가 올바르게 동작하는지를 먼저 검증하고, 이후에 여러 객체가 협력하여 전체 시스템이 요구사항을 만족하도록 동작하는지를 확인하는 통합 테스트(Integration Test)를 수행하게 됩니다.
    - 단위 테스트를 수행할 때는 테스트 대상 객체 외의 다른 객체들로부터 독립시키기 위해 목(mock) 객체를 사용하는 것이 일반적입니다. 이를 통해 테스트 대상 객체의 동작을 정확히 검증하고, 외부 객체들로 인한 영향을 제거할 수 있습니다.
    - 통합 테스트를 수행할 때는 실제 객체들이 서로 협력하는 것을 테스트합니다. 이때는 모두가 올바르게 동작하고 각각의 객체가 올바르게 협력하는지를 확인합니다.
    - 따라서, 객체간의 협력이 많아도 단위 테스트와 통합 테스트를 적절히 조합하면 효과적으로 코드를 테스트할 수 있습니다. 일반적으로 테스트 케이스 작성시 단위 테스트가 더 많이 작성되며, 개별 컴포넌트의 정상 작동을 검증하는데 집중하고, 통합 테스트에서는 전체 시스템 혹은 하위 시스템의 동작을 검증하는 데 초점을 맞춥니다. 또한, 통합 테스트를 수행할 때 다양한 시나리오를 고려하여 테스트 케이스를 작성하면 더욱 더 충실한 테스트를 진행할 수 있습니다.

- private 메서드는 어떻게 테스트하지?!
  - GPT의 의견
    - private 메서드를 직접 테스트하는 것은 좋은 테스트 전략이 아닙니다. 이는 하나의 클래스 또는 모듈 내부에서만 사용하기 위해 액세스를 제한한 메서드이기 때문입니다. private 메서드는 해당 클래스 또는 모듈의 내부 동작을 구현하는 부분이므로, 이를 직접 테스트하려는 시도는 캡슐화 원칙에 어긋납니다.
    - 대신 private 메서드가 올바르게 동작하는지 확인하기 위해 해당 private 메서드를 호출하는 public 메서드를 테스트해야 합니다. 이 방법을 통해 private 메서드가 예상대로 작동하는지 간접적으로 검증할 수 있습니다.
    - 이 또한 객체지향 프로그래밍의 기본 원칙 중 하나인 '블랙 박스 테스트' 원칙을 따르는 것이며, 오직 외부로부터 보이는 행동만을 테스트함으로써 내부 구현의 변경에도 테스트가 유연하게 대응하도록 만드는 것입니다.
    - 정리하자면, private 메서드를 직접 테스트하기보다는 해당 메서드를 사용하는 public 메서드를 테스트하여 간접적으로 검증해야 합니다.

- dispatch를 이용할 경우 함수들이 모두 private이 될수가 있다 이 경우는 테스트를 어떻게 하는가
  - dispatch 로직 삭제 하자.. 
  - println, Random 등과 같은 모듈을 사용하는 경우의 테스트
    - 메서드에 인터페이스를 이용해서 모킹으로 주입 받자
  - GPT의 예제
    ```kotlin
    interface OutputWriter {
        fun print(s: String)
    }
  
    class ConsoleOutputWriter : OutputWriter {
        override fun print(s: String) {
            kotlin.io.print(s)
        }
    }
  
    fun renderCarPosition(outputWriter: OutputWriter, car: Car) {  
        for (position in 0 until car.curPosition) {  
            outputWriter.print('-')
        }  
        outputWriter.print("\n")
    }  
  
    class Car(val curPosition: Int)
  
    class MockOutputWriter : OutputWriter {
        private val output = StringBuilder()
  
        override fun print(s: String) {
            output.append(s)
        }
  
        fun getOutput(): String {
            return output.toString()
        }
    }
  
    class YourTest : StringSpec({
        "renderCarPosition method will in MockOutputWriter print the correct string" {
            var car = Car(4)
            val mockWriter = MockOutputWriter()
            renderCarPosition(mockWriter, car)
  
            mockWriter.getOutput() shouldBe "----\n"
        }
    })
  
    ```

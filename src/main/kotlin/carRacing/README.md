# 자동차 경주 - 우승자

### 기능 요구
초간단 자동차 경주 게임을 구현한다.

- [x] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 추가 사항
- [x] 테스트 코드 작성

### 리뷰 반영
- [x] car name validate Car 내부로 넣기
- [x] repeat 함수 쓰기

### 학습한 것들
- any, all
- 여러 함수 형태 받게하기
    ```kotlin
    sealed class FunctionType {
        data class StrFunc(val function: (String) -> String) : FunctionType()
        data class IntFunc(val function: (String) -> Int) : FunctionType()
        data class BoolFunc(val function: (String) -> Boolean) : FunctionType()
    }
    
    fun runFunction(functionType: FunctionType, input: String) {
        when (functionType) {
            is FunctionType.StrFunc -> println(functionType.function(input))
            is FunctionType.IntFunc -> println(functionType.function(input))
            is FunctionType.BoolFunc -> println(functionType.function(input))
        }
    }
    ```
    ```kotlin
    val strFunc = FunctionType.StrFunc { it.toUpperCase() }
    val intFunc = FunctionType.IntFunc { it.length }
    val boolFunc = FunctionType.BoolFunc { it.isNotBlank() }
    
    runFunction(strFunc, "hello") // 출력: "HELLO"
    runFunction(intFunc, "hello") // 출력: 5
    runFunction(boolFunc, "hello") // 출력: true
    ```

### 고민한 것들
- TDD로 개발한다면 객체사이의 협력보다는 개별 역할과 책임에 중심이 되어 개발이 진행되지 않을까

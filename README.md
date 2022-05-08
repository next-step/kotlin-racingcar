# 1주차 : kotlin-racingcar
## Step1 : 코틀린 기초
- 간단한 Person 클래스 생성
- 테스트 코드 작성
## Step2 : 문자열 계산기
### 요구사항
1. 사칙연산의 계산우선순위가 아닌 입력값에 따라 계산순서가 결정된다
   (예 : 2 + 3 * 4 / 2 = 10)
2. 메서드를 최대한 분리시킨다.

### 할 일
* [x] 계산 로직 테스트 코드 작성
  * 덧셈
  * 뺄셈
  * 곱셈
  * 나눗셈
  * 사칙연산을 모두 포함 하는 경우
* [x] 계산 로직 구현
* [x] 예외처리 테스트 코드 작성
  * 입력값이 null이거나 빈 공백 문자일 경우
  * 사칙연산 기호가 아닌 경우
  * 식이 올바르지 않은 경우
* [x] 예외처리 추가
* 코드리뷰 반영
  * [x] 상수는 companion object에서 const로 정의하는 것이 좋다
  * [ ] 함수의 역할 분리
    * [ ] 유효성 체크
    * [ ] 연산자 & 연산 처리
  * [ ] 매직 리터럴 바꾸기
  * [ ] 코틀린 함수 활용
  * [ ] enum class에 인터페이스/람다 활용([💡](https://kotlinlang.org/docs/enum-classes.html#implementing-interfaces-in-enum-classes))
  * [ ] 테스트 코드 kotest로 통일



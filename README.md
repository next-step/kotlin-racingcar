# kotlin-racingcar

## 2단계 - 문자열 계산기

### 기능 요구 사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

## 도메인 모델
- `문자열 계산기(StringCalculator)`
  - [ ] 문자열을 입력 받아 사칙 연산을 수행한다.
- `수식 생성(ExpressionFactory)`
  - [X] 문자열을 입력 받아 `수식(Expression)`을 생성할 수 있다.
  - [X] 올바르지 않은 문자열 입력 시 예외가 발생한다.
- '수식 문자열 분리 전략(SeparationStrategy)'
  - 하나의 문자열을 받아 여러 개의 문자열로 분리할 수 있다.
  - 구현체: OneSpaceSeparationStrategy
- `수식(Expression)`
  - `수식(Expression)`은 여러 개의 숫자와 `연산자(Operator)`로 이루어진다.
  - [X] 숫자의 개수가 `연산자(Operator)`의 개수보다 1만큼 큰 수식을 생성할 수 있다.
  - [X] 숫자의 개수가 `연산자(Operator)`의 개수보다 1만큼 크지 않은 경우 예외를 발생한다.
  - [X] 식을 계산할 수 있다.
- `연산자(Operator)`
  - [X] 연산자 기호가 없는 경우 예외가 발생한다.
  - [X] 연산자 기호를 통해 연산자를 찾을 수 있다. 
  - [X] 두 개의 숫자를 입력 받아 사칙연산을 수행할 수 있다.
  - [X] 나눗셈의 경우 0으로 나누는 경우 예외가 발생한다.
  
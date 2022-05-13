# kotlin-racingcar

## 기능 요구 사항
* 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다
* 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다
## step2 구현 목록
* 덧셈
* 뺄셈
* 곱셈
* 나눗셈
* 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
* 사칙 연산을 모두 포함하는 기능 구현
* 테스트 구현
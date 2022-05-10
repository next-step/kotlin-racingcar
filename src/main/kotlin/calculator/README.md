# 문자열 계산기
## 요구사항
### 기능요구사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
### 프로그래밍 요구사항
메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

## 구현
### 구현기능
[X] 덧셈
[X] 뺄셈
[X] 곱셈
[X] 나눗셈
[X] 사칙연산 복합
### 엣지케이스
[X] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
[X] 숫자 및 기호를 포함하여 3개 이상 입력을 안할 경우 IllegalArgumentException throw
[X] 시작이나 끝이 숫자가 아닌 경우 IllegalArgumentException throw
[X] 사칙연산 기호 외의 문자나 기호가 들어가 있는 경우 IllegalArgumentException throw
[X] 숫자 외의 문자가 들어가 있는 경우 NumberFormatException throw
[X] 숫자나 기호가 연속하여 나온 경우 IllegalArgumentException throw

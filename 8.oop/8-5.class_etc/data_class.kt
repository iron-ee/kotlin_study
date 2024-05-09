package main.kotlin.oop.class_etc

fun main() {
    val dto1 = PersonDto("아무개", 100)
    val dto2 = PersonDto("아무개", 100)
    val dto3 = PersonDto("아무개", 200)
    println(dto1 == dto2)   // true
    println(dto1 == dto3)   // false
    println(dto1)           // PersonDto(name=아무개, age=100)  -> 물론 toString 도 동작을 잘함.
}


// 기존에 java 에서는 계층간의 데이터를 전달하기 위한
// DTO 를 작성할 때, 데이터(필드), 생성자와 getter, equals, hashCode, toString 등등 작성할 게 무지 많았음
// kotlin 에서는 data 키워드를 붙여주면 끝...
// equals, hashCode, toString 을 자동으로 만들어줌...
// 여기에 named argument 까지 활용하면, builder pattern 을 쓰는 것 같은 효과까지 ㅆㄱㄴ
data class PersonDto(
    val name: String,
    val age: Int,
) {

}


/*
kotlin 의 Data Class 를 사용하면 equals, hashCode, toString 을 자동으로 만들어준다.
 */
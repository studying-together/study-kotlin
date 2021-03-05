package st.kotlin.jun.third

import org.junit.Test

class LocalFunctionTest {

    class User(val id: Int, val name: String, val address: String)

    fun User.validateBeforeSave() {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user $id empty $fieldName")
            }
        }
        validate(name, "Name")
        validate(address, "Address")
    }

    @Test
    fun `코드 중복 예제`() {
        saveUser(User(1, "", ""))
    }

    fun saveUser(user: User) {
        if (user.name.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty name")
        }

        if (user.address.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id} empty Address")
        }

        // 저장
    }

    @Test
    fun `로컬 함수 예제`() {
        saveUser2(User(1, "", ""))
        saveUser3(User(1, "", ""))
        saveUser4(User(1, "", ""))
    }

    fun saveUser2(user: User) {
        fun validate(user: User, value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${user.id} empty $fieldName")
            }
        }
        validate(user, user.name, "Name")
        validate(user, user.address, "Address")

        // 저장
    }

    fun saveUser3(user: User) {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${user.id} empty $fieldName")
            }
        }
        validate(user.name, "Name")
        validate(user.address, "Address")

        // 저장
    }

    fun saveUser4(user: User) {
        user.validateBeforeSave()
        // 저장
    }


}
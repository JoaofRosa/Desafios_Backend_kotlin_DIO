class User(val id: Int, val name: String)

class UserManager private constructor() {
    private val users = mutableListOf<User>()

    fun addUser(name: String) {
        val userId = users.size + 1
        val newUser = User(userId, name)
        users.add(newUser)
    }

    fun listUsers(): List<String> {
        val userNames = mutableListOf<String>()
        for (user in users) {
            userNames.add("${user.id} - ${user.name}")
        }
        return userNames
    }

    companion object {
        private var instance: UserManager? = null

        fun getInstance(): UserManager {
            if (instance == null) {
                instance = UserManager()
            }
            return instance!!
        }
    }
}

fun main() {
    val userManager = UserManager.getInstance()
    val quantity = readLine()?.toIntOrNull() ?: 0

    for (i in 1..quantity) {
        val name = readLine() ?: ""
        userManager.addUser(name)
    }

    val userList = userManager.listUsers()

    for (userName in userList) {
        println(userName)
    }
}

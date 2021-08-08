package br.com.rotacilio.worktimetracker.database.dao

import br.com.rotacilio.worktimetracker.database.ObjectBox
import br.com.rotacilio.worktimetracker.models.User
import io.objectbox.Box

class UserDao : DAO<User> {

    private var userBox: Box<User> = ObjectBox.boxStore.boxFor(User::class.java)

    override fun insert(entity: User) {
        userBox.put(entity)
    }

    override fun update(entity: User) {
        userBox.put(entity)
    }

    override fun findById(id: Long): User = userBox[id]

    override fun findAll(): List<User> = userBox.all

    override fun delete(id: Long) {
        if (userBox.remove(id)) {
            return
        }
        throw Exception("It wasn't be able to delete this user")
    }
}
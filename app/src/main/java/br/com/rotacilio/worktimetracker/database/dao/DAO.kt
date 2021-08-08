package br.com.rotacilio.worktimetracker.database.dao

interface DAO<T> {
    fun insert(entity: T)
    fun update(entity: T)
    fun findById(id: Long): T
    fun findAll(): List<T>
    fun delete(id: Long)
}
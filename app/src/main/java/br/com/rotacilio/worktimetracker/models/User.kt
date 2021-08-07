package br.com.rotacilio.worktimetracker.models

import androidx.annotation.NonNull
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class User(
    @Id var id: Long = 0,
    @NonNull val firstName: String,
    @NonNull val lastName: String,
    @NonNull val email: String,
    @NonNull val password: String,
    val createdAt: Date = Date()
)
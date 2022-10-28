package com.example.Drizzle_Prj.domain.user


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository :JpaRepository<User, Long>{
    fun findByEmail(email:String):User?
}


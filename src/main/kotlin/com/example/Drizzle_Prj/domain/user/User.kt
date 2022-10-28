package com.example.Drizzle_Prj.domain.user


import java.util.*
import javax.persistence.*

//1
@Entity(name="user")
class User(var email : String,
           var password : String,
           var name: String
)
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id:Long?=null
    var createdAt:Date?=null
    var updatedAt:Date?=null

    @PrePersist
    fun perPersist(){
        createdAt=Date()
        updatedAt=Date()
    }

    @PreUpdate
    fun preUpdate(){
        updatedAt=Date()
    }
}
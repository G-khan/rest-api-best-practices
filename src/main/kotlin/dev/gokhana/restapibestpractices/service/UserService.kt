package dev.gokhana.restapibestpractices.service

import dev.gokhana.restapibestpractices.model.UserDTO

interface UserService {
    fun getById(id: Int): UserDTO
    fun getUsers(page: Int?, maxRecords: Int?): List<UserDTO>
    fun createUser(userDTO: UserDTO): UserDTO
    fun updateUser(id: Int, userDTO: UserDTO): UserDTO
    fun patchUser(id: Int, userDTO: UserDTO): UserDTO
    fun deleteUserById(id: Int)
}
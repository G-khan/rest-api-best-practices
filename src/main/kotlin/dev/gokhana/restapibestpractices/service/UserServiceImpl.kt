package dev.gokhana.restapibestpractices.service

import dev.gokhana.restapibestpractices.model.UserDTO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    override fun getById(id: Int): UserDTO {
        TODO("Not yet implemented")
    }

    override fun getUsers(page: Int?, maxRecords: Int?): List<UserDTO> {
        TODO("Not yet implemented")
    }

    override fun createUser(userDTO: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun updateUser(id: Int, userDTO: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun patchUser(id: Int, userDTO: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun deleteUserById(id: Int) {
        TODO("Not yet implemented")
    }
}
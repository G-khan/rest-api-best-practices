package dev.gokhana.restapibestpractices.service

import dev.gokhana.restapibestpractices.exception.UserNotFoundException
import dev.gokhana.restapibestpractices.model.UserDTO
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Dummy service for data
 */
@Service
class UserServiceImpl : UserService {

    override fun getById(id: Int): UserDTO {
        return findById(id)
    }

    override fun getUsers(maxRecords: Int?): List<UserDTO> {
        return maxRecords?.let { userMap.values.toList().take(maxRecords) }
            ?: userMap.values.toList()
    }

    override fun createUser(userDTO: UserDTO): UserDTO {
        userDTO.id = Random.nextInt(0 until 9999999)
        userMap[userDTO.id] = userDTO
        return userDTO
    }

    override fun updateUser(id: Int, userDTO: UserDTO): UserDTO {
        findById(id)
        userDTO.id = id
        userMap[id] = userDTO
        return userDTO
    }

    override fun patchUser(id: Int, userDTO: UserDTO): UserDTO {
        val user = findById(id)
        userDTO.name?.let {  user.name = userDTO.name }
        userDTO.email?.let {  user.email = userDTO.email }
        userDTO.detail?.let {  user.detail = userDTO.detail }
        return user
    }

    override fun deleteUserById(id: Int) {
        findById(id)
        userMap.remove(id)
    }

    private fun findById(id: Int) = userMap[id] ?: throw UserNotFoundException("User: $id not found")


    companion object {
        private var user1 = UserDTO(1, "gokhana", "gokhana@mail.com")
        private var user2 = UserDTO(2, "turkeyjavacommunity", "info@turkeyjava.com")
        private val userMap = hashMapOf(user1.id to user1, user2.id to user2)
    }

}
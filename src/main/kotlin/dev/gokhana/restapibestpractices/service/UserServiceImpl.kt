package dev.gokhana.restapibestpractices.service

import dev.gokhana.restapibestpractices.exception.UserNotFound
import dev.gokhana.restapibestpractices.model.UserDTO
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import kotlin.random.Random

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
        userDTO.id = Random.nextInt()
        userMap[userDTO.id] to userDTO
        return userDTO
    }

    override fun updateUser(id: Int, userDTO: UserDTO): UserDTO {
        findById(id)
        userMap[id] to userDTO
        return userDTO
    }

    override fun patchUser(id: Int, userDTO: UserDTO): UserDTO {
        BeanUtils.copyProperties(userDTO, findById(id))
        userMap[id] to userDTO
        return userDTO
    }

    override fun deleteUserById(id: Int) {
        findById(id)
        userMap.remove(id)
    }

    private fun findById(id: Int) = userMap[id] ?: throw UserNotFound("User: $id not found")


    companion object {
        private var user1 = UserDTO(1, "gokhana", "www.gokhana.dev")
        private var user2 = UserDTO(2, "turkeyjavacommunity", "www.turkeyjava.com")
        private val userMap = hashMapOf(user1.id to user1, user2.id to user2)
    }

}
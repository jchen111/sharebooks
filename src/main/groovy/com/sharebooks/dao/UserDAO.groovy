package com.sharebooks.dao

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.sharebooks.config.MonogoDBCredentials
import com.sharebooks.config.MonogoDBProvider
import com.sharebooks.domain.User
import com.sharebooks.dto.mapper.UserCreateResponseMapper
import com.sharebooks.dto.response.UserCreateResponse
import com.sharebooks.util.exceptions.UserAlreadyExistException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

import java.time.LocalDateTime

/**
 * Created by z001ktb on 3/18/16.
 */
@Repository
@Component(value = 'UserDAO')
class UserDAO {
    @Autowired
    MonogoDBCredentials monogoDBCredentials

    @Autowired
    MonogoDBProvider monogoDBProvider

    @Autowired
    UserCreateResponseMapper userCreateResponseMapper


    DB getCurrentMongoDB(String url, String username, String password) throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI("mongodb://" + username + ":" + password +url)
        MongoClient client = new MongoClient(uri)
        client.getDB(uri.getDatabase())
    }

    UserCreateResponse postUser(User user) throws UnknownHostException{
        BasicDBObject entity = new BasicDBObject()
        entity.put('first_name', user.getFirstName())
        entity.put('last_name', user.getLastName())
        entity.put('nick_name', user.getNickName())
        entity.put('email', user.getEmail())
        entity.put('password', user.getPassword())

        DB mongoDatabase = getCurrentMongoDB(monogoDBProvider.mongodbUrl, monogoDBCredentials.mongodbUsername, monogoDBCredentials.mongodbPassword)
        DBCollection users = mongoDatabase.getCollection('sharebooksuser')
        if(checkUserexistance(user,users)) {
            throw new UserAlreadyExistException('User already exists.')
        }
        users.insert(entity)
        userCreateResponseMapper.toUserCreateResponse(user, LocalDateTime.now())
    }

    Boolean checkUserexistance(User user, DBCollection collection){
        BasicDBObject findQuery = new BasicDBObject("email",user.email)
        if (collection.findOne(findQuery)){
            return true
        }else {
            return false
        }
    }
}

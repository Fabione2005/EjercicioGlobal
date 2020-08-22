package com.app.exercise

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

import com.app.exercise.dao.repository.UserRepository
import com.app.exercise.exception.UserInfoException
import com.app.exercise.exception.UserUnauthorizeException
import com.app.exercise.model.bean.User
import com.app.exercise.model.generic.UserToken
import com.app.exercise.service.user.UserService
import com.app.exercise.utils.TestUtilsGroovy

import spock.lang.Specification

@SpringBootTest(webEnvironment = NONE)
class UserServiceTestSpock extends Specification{

	@Autowired
	UserService service

	UserRepository repository = Mock()

	def setup() {
		service.setRepository(repository)
		service.deleteAllUsers()
	}

	def "Tirando Excepcion cuando el email ya esta registrado"() {

		setup:

		User user = TestUtilsGroovy.getUser("Virginia","Vigi@yahoo.com");

		repository.findByEmail(user.getEmail()) >> Optional.of(user)

		when:
		service.addUser(user)

		then:
		thrown(UserInfoException)
		0 * repository.save(user)
	}

	def "Traer todos los usuarios"() {
		setup:
		def name = "Roberto"

		User user = TestUtilsGroovy.getUser(name,"Ronnie@yahoo.com")

		def mockUsers = []
		mockUsers << user
		repository.findAll() >> mockUsers

		when:
		def users = service.retriveUsers()

		then:
		users.body.size() == 1
		users.getBody().get(0).name == name
	}
	
	def "Autentificacion fallida por usuario inactivo"() {
		setup:
		
		UserToken user = new UserToken("someEmail@hotmail.com","AAAccdda125")

		repository.findByEmail(user.getUserEmail()) >> Optional.empty()

		when:
		service.loginAuth(user)

		then:
		thrown(NullPointerException)
		1 * repository.findByEmail(user.getUserEmail())
	}
	
	def "Guardar usuario exitosamente"() {
		setup:
		
		User user = TestUtilsGroovy.getUser("someName","someEmail@hotmail.com",false)

		repository.findByEmail(user.getEmail()) >> Optional.empty()

		when:
		def userResponse = service.addUser(user)

		then:
		userResponse.getStatusCode() == HttpStatus.OK
		1 * repository.save(user)
	}
	
	
}

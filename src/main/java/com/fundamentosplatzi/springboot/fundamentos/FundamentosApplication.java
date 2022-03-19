package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.Entity.User;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependecy;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependecy componentDependecy,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository
	){
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info(
		"Usuario con el metodo findByUserEmail " +
			userRepository.findByUserEmail("daniela@gmail.com")
					.orElseThrow(() -> new RuntimeException("No se encontro el usuario"))
		);

	}

	private void saveUsersInDataBase(){
		User user1 = new User("Guido","gmauriciocd@gmail.com", LocalDate.of(2021,9,20));
		User user2 = new User("Mauricio","mauricio9cordova@gmail.com", LocalDate.of(2021,2,13));
		User user3 = new User("Daniela","daniela@gmail.com", LocalDate.of(2021,2,27));
		User user4 = new User("Alberto","alberto@gmail.com", LocalDate.of(2021,2,10));
		User user5 = new User("user5","user5@gmail.com", LocalDate.of(2021,2,5));
		User user6 = new User("user6","user6@gmail.com", LocalDate.of(2021,3,25));
		User user7 = new User("user7","user7@gmail.com", LocalDate.of(2021,4,22));
		User user8 = new User("user8","user8@gmail.com", LocalDate.of(2021,5,20));
		User user9 = new User("user9","user9@gmail.com", LocalDate.of(2021,6,15));
		User user10 = new User("user10","user10@gmail.com", LocalDate.of(2021,7,12));
		List<User> list = Arrays.asList(user1, user2, user3,user4,user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		LOGGER.error("Esto es un error");

		try{
			int value = 10 / 0;
			LOGGER.debug("Mi valor " + value);
		}catch(Exception e){
			LOGGER.error("Esto es un error al dividir por cero " + e.getMessage());
		}
	}
}

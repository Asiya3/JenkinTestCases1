package com.Crm.Vtiger;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {


	public int generateRandomNumber()
	{
		Random random=new Random();
		return random.nextInt(10);
	}
	public String fakeFirstName()
	{
		Faker faker=new Faker();

		return faker.name().firstName();

	}

	public String fakeLastName()
	{
		Faker faker=new Faker();

		return faker.name().lastName();
	}

	public String fakeAddress()
	{
		Faker faker=new Faker();

		return faker.name().fullName();
	}

	public String fakeCompany()
	{
		Faker faker=new Faker();

		return faker.company().name();
	}


}

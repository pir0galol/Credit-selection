# Credit selection application
* **Objective:** receiving the desired credit according to your needs;
* **IDE:** Eclipse Oxygen - Java SE 8;
* **Database:** PostgreSQL;
* **Server:** Apache Tomcat 9.0 (locally deployed);
* **Persistence:** JPA 2.2.0 + EclipseLink 2.7.0;
* **JSF:** Mojjara 2.2.9 + BootsFaces 1.2.0;
* **Drools:** 1.9.2 (for business rules).
* **Language of the application:** Romanian;
* **Prerequisites:**
  * PostgreSQL database installed and configured;
  * PostgreSQL data provider library 42.1.4;
  * Eclipse Oxygen (or other IDE) with Java SE 8 or later;
  * Apache Tomcat 9.0 server;
  * JPA persistence 2.2.0 libraries;
  * JSF Mojjara 2.2.9;
  * Drools 1.9.2;
  * BootsFaces 1.2.0 libray.

* **Modules:**
  * **Operations;**
  * **Analyzer.**
  
#### The first page of the application contains a nice and warm welcome:

![11](https://user-images.githubusercontent.com/36104236/35930519-cc6a372a-0c3a-11e8-877b-bfbd621a1095.PNG)

1. **Operations:**

  * **New bank**
  
  <p>As the name suggests, on this page you could add a new bank in the database. Later on, assign specific credits for this new bank.</p> 
  
![2bank](https://user-images.githubusercontent.com/36104236/35930567-ef3c4a72-0c3a-11e8-8b52-6fd3a18f3cdd.PNG)
  
  * **New credit**
  
  <p>Create and assign specific credits to a bank (existing one or created earlier)</p>
  
![2credit](https://user-images.githubusercontent.com/36104236/35930590-fc3e20ec-0c3a-11e8-8637-3a365a13f470.PNG)

  * **Banks list**
  
  <p>This page will retrieve a list with all the banks registered in the database.</p> 
  You have the possibility to edit, delete a bank and retrieve the credits for the specified bank. Moreover you can delete a specific credit listed for the bank you have selected.
  
![3list](https://user-images.githubusercontent.com/36104236/35930603-08689690-0c3b-11e8-91c6-24f99af6a966.PNG)
    
  <p>Every modification notifies the user with a specific message. Let's delete for instance the Zetta bank. It will automatically delete the bank and the credits related to it.</p>

![3list_delete_zetta](https://user-images.githubusercontent.com/36104236/35930644-27077bf2-0c3b-11e8-93d3-3c8374741162.PNG)

2. **Analyzer**
  <p>A user interested in contracting a specific credit and having certain requirements (for instance value, period, currency) can access this module.
  
  ![4analyzer](https://user-images.githubusercontent.com/36104236/35930675-409c0344-0c3b-11e8-9a23-5982dd66e104.PNG)
  
  This module is responsible for taking user's inputs and based on additional elements such as person's income, age, length of work, marital status etc.
  (this is where Drools rules defined come in) it will calculate a score, iterate through the credits for the banks in the database and
  return the best credit option for the user, ranking the results. Additionally, it calculates the first payment rate and the total return for each result.
  We took an example:</p>
   * Credit type: "Personal Needs";
   * Credit value: 2500;
   * Credit period: 5 (years);
   * Credit currency: RON;
   * Current occupation: Manager;
   * Activity domain: Financial institutions..
   * Family situation: Married (with max 2 family members without any income);
   * Locative situation: Property;
   * Income: 3600 RON;
   * Length of work: 3 (years);
   * Age: 26 (years).
   
   ![44analyzer](https://user-images.githubusercontent.com/36104236/35931095-63f07fb8-0c3c-11e8-90ba-e62597f9290d.PNG)
   
   And the final results:
   
   ![5results](https://user-images.githubusercontent.com/36104236/35931108-6f37c55c-0c3c-11e8-825c-a4a251d3caa0.PNG)
   
   As we can notice, the best credit options for our requirements is "Creditul Fantastic" which can be found at the bank
   "Banca Fantastica". Also the first rate for our credit value is 47.29 RON and we should return at the end of those 5 years,
   no more and no less than 3002.11 RON.
  
  ### Final considerations
  
  <p>This project was made for educational purposes. However, it is not perfect. In the future, further improvements will be made,
  considering the fact that at this moment it addresses only natural persons, and not legal persons.</p> 
  
  

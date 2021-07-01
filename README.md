# Opera-App
<img src="https://www.broadwaysf.com/content/Images/venues/2000x742%20BSF_GGT_077.jpg" >

A prototype of an opera shop, where people can buy tickets for performances. <br>
In this project used N-tier architecture with DAO layer, Service layer, Controllers layer.
Project was developed according to SOLID principles with users authentication and authorization.

Users can perform the following actions:
- register on the opera shop website;
- log in and out;
- look through the performances;
- add tickets to their cart;
- delete tickets from the cart;

Admins in their turn can:
- view all registered users;
- delete users from the database;
- view all orders placed at the store;
- edit performances.

<h3>Technologies used:</h3>
<ul>
  <li>Spring Core, Web, Security</li>
  <li>Hibernate</li>
  <li>Servlet</li>
  <li>MySql</li>
  <li>Json</li>
  <li>Tomcat 9.0.46</li>
  <li>Maven</li>
  <li>Maven Checkstyle Plugin</li>
</ul>

<h3>Setup:</h3>
1. To run the project on your computer, clone this project into your local folder and open the project in an IDE. <br>
2. Install MySQL and MySQL Workbench, to configure MySQL you can use the script from resources/db.properties.<br>
3. Add your parameters to taxi/util/ConnectionUtil.java<br>
<ul>
  <li>Driver</li>
  <li>Url to your database</li>
  <li>Your login to DB</li>
  <li>Your password to DB</li>
</ul>
4. Configure Apache Tomcat before you run the app.<br>

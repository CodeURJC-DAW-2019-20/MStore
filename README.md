## Web Application Development Practice 📄

# MSTORE ⌨️

_MSTORE is a website created with the objective that customers can sell or buy technological devices._

## Phase 0: Definition of web functionalities. 🚀

_We are the group number 10 of the subject **Web Application Development.** The team consists of 5 members:_

### Members ✒️

|   NAME        | EMAIL         | Github Username  |
| ------------- |:-------------:| -----:          |
| Daniel Ruiz Bustos      |d.ruizb.2017@alumnos.urjc.es  | druizb1999 |
| Marcos Ruiz Muñoz      | m.ruizmu.2017@alumnos.urjc.es      |   Markete17 |
| Jose Luis Sierra Benito | jl.sierra.2017@alumnos.urjc.es      |    Jos3lu |
| Noelia Martínez Sánchez | n.martinezs.2017@alumnos.urjc.es      |    nmartinezs2017 |
| Diego Montoto Ramos | d.montoto.2017@alumnos.urjc.es      |    Dimonra13 |

### Video Presentation 📹
[![](http://img.youtube.com/vi/DXHCQfdYcrY/0.jpg)](http://www.youtube.com/watch?v=DXHCQfdYcrY "Presentation")

### Entities 💡 
- Posts
- User
- Brand
- Rating

### Type of Users 😃
- Visitors
- Registered Users
- Administrators

### User permissions 🔒
_Registered users will have more permissions and functionalities than visiting users. Only registered users can access their profile information, make purchases and sell products. Administrators have their own page to delete or edit posts._

### Images 🎨
- User profile picture
- Products image
- Brands image

### Graphs 📊
_There are bar charts in the product sales ratings of the selling users._

### Complementary technology 💻
_Sending mail to users._

### Advanced algorithm 📌
_A system of personalized offers and recommendations based on the products that the user has seen and visiting._

## **Phase 1: Page layout with HTML and CSS.**

### 1. HOME
<p align="justify">
This capture represents the main page of <b>MSTORE</b>. It consists of a search engine at the top so that the user can find their products more easily. In addition, the menu of the website formed by different sections is shown: <b>Home, Shop, Sell product and User account</b>. The most outstanding products that are being sold and items that are on sale will also appear. The predominant brands of the market are shown at the bottom. You can also see three columns that show the articles <b>Best Seller, New Arrivals and Top Rated</b>. The last part represented with black background, will be available in all windows and its functionality is that the user can subscribe to offers or see the departments and brands that are treated.
</p>

### 2. SIGN IN AND CREATE ACCOUNT

 <p align="justify">
This window is a drop-down located on all <b>MSTORE</b> pages. It allows the user to be able to log in at any time. It consists of two fields: <b>email</b> and <b>password</b>, although it also gives the possibility to log in through social networks. In the case of not having an account, the <b>registration</b> option will be available. The option to create an account consists of four fields: <b>full name, email address, password, confirm password </b>.
  </p>
  
### 3. SHOP

 <p align="justify">
This window shows the available items. Each product is represented with an image, a brief description and the price. Through categories and filters located on the left side, products can be found more efficiently. In addition, there is the possibility of sorting by popularity and how to adjust the number of products per page.
  </p>
  
  ### 4. PRODUCT VIEW
  
 <p align="justify">
  When the item is selected in the <b>Shop</b> section, the <b>images, details, features, specifications are shown in detail </b>. In addition, the <b>rating of the product</b> is shown next to the name of the seller. You can select the quantity you want to buy and then add them to the <b>shopping cart</b>. At the bottom, <b>recommendations of articles</b> similar to the selected one will be displayed.
  </p>
  
  ### 5. SELL PRODUCT
  
  <p align="justify">
  <b>To sell and publish a product</b>, you will have to fill in the fields related to pick up <b>address and product information </b>. On the left side it shows the profile picture next to the contact information. In addition, it gives the possibility to modify profile data.
  </p>
  
  ### 6. PROFILE
   <p align="justify">
  The windows of the <b>User Account</b> section are formed by the same format pattern. They are represented by a photo of the user along with their <b>contact information</b>. Access to your purchase<b> tickets</b> and </b>purchase history information</b>. In addition, there is an option to </b>log out</b> at any time.
  </p>
  <p align="justify">
  It will be possible to <b>edit all profile information</b> except the registration email. In addition, it will <b>enable or disable receiving offers</b> from the website.
  </p>
  
  <p align="justify">
  Account Addresses: Like editing profile information, you can <b>modify the address data</b> associated with the account. You can also enable or disable Same as Contact Address.
  </p>
  
  ### 7. CART
  
   #### Description
  <p align="justify">
It is a drop-down window where the selected products are found while browsing the page. The <b>name, image and quantity of each product and the total price</b> of each product are displayed. In the lower part the <b>total of the purchase is shown</b> and will give the possibility of <b>adding more items</b> to the cart or checkout.
  </p>

  ### 8. SELLER'S VIEW
  
  <p align="justify">
  The screen represents the <b>information of the seller</b>. A photo of the user's profile is displayed next to their contact information. It will have <b>associated a graph</b> with the ratings that the seller has had. At the bottom there will be <b>links to your other products.</b>
  </p>
  
  ### 9. CHECKOUT
<p align="justify">
  The <b>Checkout</b> section will consist of five stages: <b>Shopping cart, Your details, Shipping, Payment, Final review</b>. In each stage you have to fill in some mandatory <b>fields or select different options</b>. At the top it will indicate the stages that have been completed and the stages that are still to be completed. If necessary, you can go from one stage to another to modify inserted data. The total amount of money to pay and the opportunity to enter a promotion code will appear on the right side. Once the purchase is successful, a new window will appear with an informative message with the order ID and also to be able to see the status and tracking of the order.
  </p>
  
  
 ---------------------
 ## **Phase 2: Web with HTML generated on server and AJAX.**
 
 ### Navigation
 
> The navigation diagram has been updated, as well as the screenshots of the main pages of the application


#### 1. Home

![h1](https://i.imgur.com/DBYq5Cw.png "Home")

#### 2. Shop

![h2](https://i.imgur.com/EIxLhEN.png "Shop")

#### 3. Sign in / Create account

![h3](https://i.imgur.com/BRnFbEj.png "Sign in / Create account")

#### 4. Product view

![h4](https://i.imgur.com/nnUjZxa.jpg "Product view")

#### 5. Product selling page

![h5](https://i.imgur.com/vipzYLZ.png "Product selling")

#### 6. Profile

![h6](https://i.imgur.com/ehmn2Ee.jpg "Profile")
![h10](https://i.ibb.co/r6DYcgZ/Captura.jpg "Profile")


#### 7. Cart
![h7](https://i.imgur.com/wSFeTCr.png "Cart")

#### 8. Admin page
![h8](https://i.ibb.co/6vJmk5r/1.jpg "Search")
![h9](https://i.ibb.co/PtdCVMc/2.jpg "Remove and Edit")

### Navigation Diagram 📊
![h11](https://i.ibb.co/176SXkN/Navigation-Diagram-bicubic.jpg "Navigation")

---------------------
 
  ### Development instructions ⚙️
  #### Development tools
  * [![Spring](https://img.shields.io/static/v1?label=Install&message=Spring%20Tools&color=brightgreen)](https://spring.io/tools)
   * [![MySQL](https://img.shields.io/static/v1?label=Install&message=MySQL&color=blue)](https://dev.mysql.com/downloads/installer/)
   * [![Mustache](https://img.shields.io/static/v1?label=Install&message=Mustache&color=red)](http://mustache.github.io/)
   * [![Maven](https://img.shields.io/static/v1?label=Install&message=Maven&color=blueviolet)](https://maven.apache.org/)
   * [![Eclipse](https://img.shields.io/static/v1?label=Install&message=Eclipse&color=yellowgreen)](https://www.eclipse.org/)

#### Dependencies
These are the dependencies that have been added to the pom.xml:
* Spring Security: Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. [Source](https://spring.io/projects/spring-security)
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```
		
* Spring Data JPA: Spring Data JPA provides repository support for the Java Persistence API (JPA). It eases development of applications that need to access JPA data sources. [Source](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#project)

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
```
* Mustache: It's a logic-less template engine for creating dynamic content, which is popular due to its simplicity. If you want to discover the basics, check our introduction to Mustache article. [Source](https://www.baeldung.com/spring-boot-mustache)

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mustache</artifactId>
		</dependency>
```
* MySQL: 
```
        <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
         </dependency>
 ```
 * Spring-Boot-Devtools: Spring Boot includes an additional set of tools that can make the application development experience a little more pleasant. The spring-boot-devtools module can be included in any project to provide additional development-time features. [Source](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
```

#### How to run the application with Eclipse
1. Clone this Git repository
2. Import the project:
![i1](https://i.imgur.com/B2qihJE.png "Step 1")
![i2](https://i.imgur.com/9RniXYO.png "Step 2")
![i3](https://i.imgur.com/VdSHmZE.png "Step 3")

3. Run the application:
![i3](https://i.imgur.com/HNYfnRO.png?1 "Run")
4. Now the application is available at https://localhost:8443/

#### How to run the application with VS Code
1. Clone this Git repository
2. Open the folder in which you cloned the repository
3. Configure the database (for more information you should visit the next section)
4. To run the application, press the "Run As ..." button and wait for the icon to turn green.
![Running](https://i.imgur.com/RAD2S4V.png "Run App")
5. Now the application is available at https://localhost:8443/

* For everything to work correctly you should install the following VSCode extensions: "Maven for Java", "MySQL", "Spring Boot Extension Pack", "Spring Boot Tools".

### How to configure the database
1. Start MySQL Workbench
2. Connect to the database with Database> Connect to database

```
Database access credentials:
	Username: root
	Password: pass
```

![DB1](https://i.imgur.com/GVyMdN1.png "Connect to database")

3. Create the "mstore" table by running the following query
![DB2](https://i.imgur.com/1oOfE4I.png "Query")
4. Import the files contained in the "databasedata \ dbdata" directory
![DB3](https://i.imgur.com/qps4oqL.png "Data import")

5. Once everything has been imported, you will be finished.
![DB4](https://i.imgur.com/w2TAwNy.png "Data import")

#### Demo accounts
```
Admin user:
	Username: admin@gmail.com
	Password: admin
```

```
User:
	Username: pepita@gmail.com
	Password: pepito
```

#### Repository Structure
* MStore / backend: The main folder, which contains the application code.
* MStore / backend / src / main / resources: It contains the HTML, CSS and JavaScript documents that have been used for the Front End of the web.
* MStore / backend / src / main / java / store / main: Contains the web backend code.
* MStore / backend / src / main / java / store / main / controller: Contains the application controllers.
* MStore / backend / src / main / java / store / main / database: It contains the entities with their corresponding repositories.
* MStore / backend / src / main / java / store / main / security: It contains the file in which the web security has been configured (user permissions).
* MStore / backend / src / main / java / store / main / service: Folder that contains some services that have been implemented

---------------------

  ### Entity Relationship Diagram (ERD) 📈
  ![DB5](https://i.ibb.co/4Zm1Cq7/model.jpg "ERD")

  
---------------------

### UML Class Diagram 📂📘
![UML1](https://i.ibb.co/MCX3MBN/1.jpg "UML")
![UML2](https://i.ibb.co/jkJ861J/2.jpg "UML")
![UML3](https://i.ibb.co/bdRjC0h/3.jpg "UML")

---------------------

### Members Participation ✅

| Plugin | Description | 5 most important commits | 5 most relevant files
| ------ | ------------- | ------------| ------| 
| Daniel Ruiz Bustos | In this phase, I have made the shop single product page and the cart page. I've also made the cart and single product controllers including the images view and the add and remove from cart functionalities. Additionally i did add the rating functionaliy to the product page and some example data.| <ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/b0389640013f4fb9b5129e87c5799166e054c110">Updated product page, cart icon and window and cart page</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/58273d33a0069b5454feadae159b98636396a485">Added the example cases to mySQL, added the database Script to load them </a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/46613eb8a780a8da01db9cb8196ed877934920db">Added error pages</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/fa407c384303ab6e65976b50986d25a64470de3e">Completed the functionality of the product page</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/8dd930d34613f84a7fc7ea28795fa5b2239e1df9">Loaded the cart on the other pages </a></li></ul>|<ul><li>ComponentController.java</li><li>ErrorControler.java</li><li>CartController.java</li><li>cart.html</li><li>shop-single-electronics.html</li></ul>
| Marcos Ruiz Muñoz |In this phase, I have made the Home page, the navigation of the page updating the header and the links. I have implemented the advanced algorithm of recommendations. Also the functionality of buying a product, added more data in database and made the Readme diagrams. I have helped to make the Cart page.  |<ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/7cd87bd0efdcdc25f1e5ee3d6bf4fc87c7fde1a4">Added HomeController & fixes</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/739978554c55072b88af86e648944ba282779ae0">Updated carrousell & buy item</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/79b436e2f7f4ec62768a5f39df00f453e973d837">Advanced algorithm implemented</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/ae2a7bed7b91422962d1df54edeab5d6830d9198">Final Review(*) & header updated</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/d9d3607a678ab7e345b0820c0d03d1d5321a3cbc">Update README</a></li></ul>|<ul><li>HomeController.java</li><li>index.html</li><li>CartController.java</li><li>ComponentController.java</li><li>shop-single-electronics.html</li></ul>
| Jose Luis Sierra Benito | In this phase, I've implemented everything related to the administrator (java and html) and the security (login, register, ...) except CSRF. I've contributed to do the the search box of the header and i have also done the payment page. | <ul><li>[Added security](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/c48f81cefe415e8adf98c14141e175f5156db2a4)</li><li>[Added sign up](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/e347d963e9f99ed6128762dc890554fa34e2304d)</li><li>[Added security permissions and a new error](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/dbbdc5ce562e2a2b5fd7a25b0684617aea73eaf4)</li><li>[Added payment page and fixed some cart bugs](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/c73b5c83b7e4401d9cc4d979c58db18c3f45e3ea)</li><li>[Implemented admin page](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/a3c10f7360d2616304f96a0e86598d15232e44d4)</li></ul> | <ul><li>AdminController.java</li><li>UserController.java</li><li>SecurityConfiguration.java</li><li>admin-page.html</li><li>checkout-payment.html</li></ul>|
| Noelia Martínez Sánchez | I have implemented the entire "Shop" page with the methods of filtering, paging with JavaScript, etc. I have also implemented complementary technology, security with CSRF, drafted the README, among other things. | <ul><li>[Shop fully implemented](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/f51b2b4e1f4ba93160d9da158c1163127d2c555e)</li><li>[Shop Paging and Sorting](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/b0915cea6b39e295a68136ed9f725b266bb0bdbc)</li><li>[Mailchimp included & footer finished on all pages](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/eadde7dce3a546cbfefee5d1587a0fc04350a053)</li><li>[Update README: Phase 2](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/286a70774d46c625228beebe93a67eeb60cd94d5)</li><li>[CSRF](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/6672bd3f6d1a3c93662e5b87111f6d529d6f3f65)</li></ul> | <ul><li>ShopController.java</li><li>shop-style2-ls.html</li><li>shop-brand.html</li><li>README.md</li><li>SellerProfileController.java</li></ul>|
| Diego Montoto Ramos | In this phase, I have implemented the database, the image service necessary to upload images, the page to edit the user profile, the page tu register new products, the rating system and the star graphic. Also helped with the menu search box. |<ul><li>[Database implemented](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/61cb37b7f40949e1767005e5a56949cc34e46a84)</li><li>[User profile updated](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/7a606b2bde9d1668ca911ae38a96deed928dbbde)</li><li>[Sell new product section updated](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/64fbbb9188065600fafadb7f49d85b0856569dd3)</li><li>[Rating system added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/f6525a3e5fc7f8633d22518e7d3780755caebf03)</li><li>[Star Graphic added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/6dc50ace9bf62982a0e50a27b8642f0faad21acf)</li></ul> | <ul><li>User.java</li><li>UserProfileController.java</li><li>SellerProfileController.java</li><li>SellProductController.java</li><li>ImageService.java</li></ul>|

---------------------

## **Phase 3: REST API to the web application and deployment with docker.**

### Building the image

To create the image, we have provided the file script.bat. Don't forget to edit it and change {{path}} for the corresponding absolute path. You should also change "nmartinezs2017/webapp10" to the name of the image you want.

### Executing the dockerized application

Go to the "backend / docker" directory to execute the following command:

```
docker-compose up
```

### REST API Documentation Link 🔗

<a href="https://github.com/CodeURJC-DAW-2019-20/MStore/blob/master/API.md">API Documentation</a>

---------------------


### UML Class Diagram 📂📘

![UML1](https://i.ibb.co/wyqx2R5/Untitled-Diagram-9.jpg)
![UML2](https://i.ibb.co/CV1RMWV/Untitled-Diagram-10.jpg)
![UML3](https://i.ibb.co/LJ8jVKQ/Untitled-Diagram-11.jpg)


### Members Participation ✅

| Plugin | Description | 5 most important commits | 5 most relevant files
| ------ | ------------- | ------------| ------| 
| Daniel Ruiz Bustos | In this phase, I have made the Get methods for every class except the post one and I have made all the methods for the cart, get post, put and delete, I also created example cases to try the applocation on.| <ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/de5b0b674ba1e37d6856841da441b515dfe1f44e">prepared the cart service and cart class for the REST service</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/ac76feddb45ddd9cadfcbadb20afe91b2de6fc91">added brand GET method to the REST service </a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/4e92c7735eb1202082af31ca1fcea6bbe939719d">added user get methods to the REST API</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/44dd4f5dd2aa42b04527943aacf6fca87850580e">added rating GET method to REST API</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/595915080fb4cc8d14d31d495b7ff6be3f8b03b1">added cart REST API with GET, PUT, POST and DELETE methods</a></li></ul>|<ul><li>BrandRestController.java</li><li>PostRestController.java</li><li>UserRestController.java</li><li>CartRestController.java</li><li>RatingRestController.java</li></ul>
| Marcos Ruiz Muñoz |In this phase I have done the delete methods in the REST API. Also, I have carried out the image management and the recommendations algorithm in the REST API. In addition, I have contributed to the writing of README.md and API.md  |<ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/0d815d14613b59166ecd676da35361cbfebfaf65">Added post DELETE method to REST API</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/71d2a20b493ab45b5fe48f6ea62617c97e016f4d">Added user image and post image GET method to REST API</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/c20173f01c77a891be825e67d00bc60606feeeea">Added user image (PUT) & post image(POST) methods to REST API</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/f214367f24bf7add43bc1c1ed8ec94121ffb11f7">Advanced algorithm added to the REST API</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/ac73984e656be4a4ef3e6a418c118ea7a6ca6f1e">Update API.md & Readme.md</a></li></ul>|<ul><li>PostRestController.java</li><li>ImageRestController.java</li><li>ImageService.java</li><li>PostService.java</li><li>API.md & Readme.md</li></ul>
| Jose Luis Sierra Benito | In this phase, I have implemented the put methods of the API REST. I have also done the part related to the security and login/logout. | <ul><li>[PostRestController put implemented & added BrandRestController](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/1ee1ae02942357c92950392d07ce189035a5a3ed)</li><li>[Added brand with PUT method to REST API](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/e92bda0c5136f07db9fe629b9c8a5a0c40058a2f)</li><li>[Added rating PUT method to API REST](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/7ffa3063a8401590c9468ba5cac3b55ce58336ba)</li><li>[Added user PUT method to API REST & few changes in Post API REST](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/b50f27fc4db44f7ba28554a161d2eb1c1f0e3284)</li><li>[Added security to the API REST & CSRF modified](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/4850134ae39dc046319766b5ba7668ca46909b71)</li></ul> | <ul><li>LoginRestController.java</li><li>PostRestController.java</li><li>RestSecurityConfig.java</li><li>UserRestController.java</li><li>UserService.java</li></ul>|
| Noelia Martínez Sánchez | In this phase, I have implemented the GET POST method with filtering and search criteria. In addition, I have done the dockerization. | <ul><li>[GET POST fixed with status and error code](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/e8b131252597632083f4831ea8bdeab70538cae1)</li><li>[GET POST by brand and component tag (filters included)](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/f6c29be1047f800114ebd0362e5ac8ac5514f14d)</li><li>[Script](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/a9bacb10617a5fdd3194681f93b2aec7701b2d12)</li><li>[Docker compose](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/93950db32277a044e3d1edf853b52ac796a536c7)</li><li>[Dockerfile](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/a9fef3219365e931378f2db9e0a100be057749b3)</li></ul> | <ul><li>script.bat</li><li>Dockerfile</li><li>docker-compose.yml</li><li>README.md</li><li>PostRestController.java</li></ul>|
| Diego Montoto Ramos | In this phase, I have implemented the POST method for user, rating and post and the GET method for the graphics. I have also added the JsonView in the database, participated in the API login system and prepare the app for jar building. |<ul><li>[JsonView implemented in the database](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/4ddc7ea87cc12cc26a6e1955247b9130fcdba876)</li><li>[Rest login added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/8cb0a5b16f2f9ae9ddfc3456f63f49a41e7e3921)</li><li>[Post methods updated](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/ac3ce837102f342654cf4d5f95018aa488d434c2)</li><li>[Graphic Rest Controller added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/a85bcf3de6c7ccdd05d7f476f8a396b30be78f48)</li><li>[Pom updated for jar building](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/bcab072ac815a8aa4d85341aa84218d4eb5e6b46)</li></ul> | <ul><li>Rating.java</li><li>UserComponent.java</li><li>PostRestController.java</li><li>UserRestController.java</li><li>GraphicRestController.java</li></ul>|

---------------------
## **Phase 4: Web with SPA Architecture..**

### Preparation of the development environment ⚙️
First of all we have to install node.js (download it <a href="https://nodejs.org/es/download/">here</a>). One you have installed it, go to the terminal and execute the following commands:
<ol>
	<li>Install the Angular CLI globally with the command: npm install -g @angular/cli</li>
	<li>Go to the workspace folder "frontend" (cd ../MStore/frontend)</li>
	<li>To download the modules use "npm install"</li>
	<li>Use "npm start"</li>
</ol>

---------------------

### UML Class Diagram 📂📘

![UML3](https://fotos.subefotos.com/ce584db11dc6f1d00dfe0e8afd56dfbeo.jpg)
![UML4](https://fotos.subefotos.com/a30664cb84844b3bdde0adf6fbce93ceo.jpg)
---------------------

### VIDEO 📹

https://youtu.be/ENe62ffhTeM
---------------------

### Members Participation ✅

| Plugin | Description | 5 most important commits | 5 most relevant files
| ------ | ------------- | ------------| ------| 
| Daniel Ruiz Bustos | In this phase, I have implemented the cart functionality alongside the "post" page, part of the footer and the error handling in angular. | <ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/89f3ebf43175cbe14a42f0f27d177d14e5d70d1d">added a functional rating display to the product page</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/d01256a82bda029f50c68ed5d4468d952ccf2685">made html pages for product and cart and added ng bootstrap</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/cf6c29dec5f46008a134d803af7814caeb5df955">added invalid route error page, added error interceptor prototype and added the image carousel to the product page </a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/32915372be147d9731366af9324d85287ba981f5">added cart and error handling</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/eb86c9960c48d20a5ff9e889d9a26b047e460a7c">several small fixes and tweaks to the cart ui</a></li></ul>|<ul><li>post.component.ts</li><li>cart.component.ts</li><li>error-interceptor.component.ts</li><li>cart.component.html</li><li>post.component.html</li></ul>
| Marcos Ruiz Muñoz |In this phase, I have been in charge of making the main page, advanced algorithm for recommendations, header, final review and a reusable component to view posts. Also, I have updated the Readme including class diagram.  |<ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/25a0ef48a896547a95e5f26a07fee92bc323425b">indexComponent added</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/b58aa0ad67c40eaa6544091ee252b3e168eea60b">added advanced algorithm, index and final review modified</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/e6e7f729bdc07ac3635e46726f1075514b8ff283">added finalReview component</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/61f481bf29dc942e83981ec589bc20ce6ecc497a">added reusable html to view posts</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/3dac502e1419f2caa315ea467d45c3db09910c88">Update Readme.md added class diagram</a></li></ul>|<ul><li>index.component.ts</li><li>finalreview.component.ts</li><li>header.component.ts</li><li>post.component.ts</li><li>Readme.md</li></ul>
| Jose Luis Sierra Benito | In this phase, I've done sign in/up, payment, complete & admin page. I have implemented the security/restrictions, the funcionality of the search box, stepper (in the payment & final review pages), header & footer. | <ul><li>[Added stepper, payment & complete component, also made other few changes](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/d500132f11eed7d0cb574e5cdd59c76823a0b571)</li><li>[Added admin component, pipe for search box & user model](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/2b3222aeaa756d29e31c2899fac412bcc6ce0e64)</li><li>[Added login & register, also added access restrictions](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/4b0d266bb265f0b11abbed89d27ec40558ac01d0)</li><li>[Added restriction to admin page & implemented payment page](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/2c38896735b71b61b4099d891402409eacff1209)</li><li>[Updated menu (implemented frontend cart)](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/83e63773e2b036b5b95c5d50cc79a218902f12eb)</li></ul> | <ul><li>admin.component.ts</li><li>login.component.ts</li><li>header.component.ts</li><li>payment.component.ts</li><li>authentication.service.ts</li></ul>|
| Noelia Martínez Sánchez | In this phase, I have fully implemented the "Shop" page with all its filters and search methods. I have also done the Docker part. | <ul><li>[View more working](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/d3b2b47ba4e18fa3653e1665894747dd32fc194b)</li><li>[Interactive vertical menu with Ngbootstrap](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/382f26d8f7df86723162aa3ba46e672623ff2523)</li><li>[Some filters added & Brand Service](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/be7ba1db21f3c385c5aa6983e6ef4532c67d90f1)</li><li>[Now you can search by tag](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/ab198a54c52f25b005e866cf0512a8845a4d9230)</li><li>[Layout of the "Shop" page](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/630ff615289a09a68b77fe6443b0ff298bb6e033)</li></ul> | <ul><li>script.bat</li><li>post.service.ts </li><li>loader.service.ts </li><li>shop.component.ts</li><li>shop.component.html</li></ul>|
| Diego Montoto Ramos | In this phase, I have implemented the image service, the graphics service, the update profile page and the sell product page. I have alse updated the backend for CORS policy and modified the pom.xml for angular deployment in  https://localhost:8443/new. |<ul><li>[Image service added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/04b4ba9fb466aa00b26cf34a435c2004672b402e)</li><li>[Graphics service added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/610df375bd95e1104b76e4c50cc41c7db9f3a52d)</li><li>[update profile an sell new product added](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/20e65e31f315f92e2977dd49224e882154267985)</li><li>[CORS policy added, user service added & bugfix](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/55f7eafa6227d8a9d6792b611c81a615ba37e6d6)</li><li>[App ready for deployment](https://github.com/CodeURJC-DAW-2019-20/MStore/commit/4ce845e6294a3a1bd3b5345485fca5f3b4a36252)</li></ul> | <ul><li>image.service.ts</li><li>graphics.service.ts</li><li>edit-profile.component.ts</li><li>RestSecurityConfig.java</li><li>pom.xml</li></ul>|

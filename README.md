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

## Phase 1: Page layout with HTML and CSS

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
 ## Phase 2: Web with HTML generated on server and AJAX
 
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
| Daniel Ruiz Bustos | |
| Marcos Ruiz Muñoz |In this phase, I have made the Home page, the navigation of the page updating the header and the links. I have implemented the advanced algorithm of recommendations. Also the functionality of buying a product, added more data in database and made the Readme diagrams. I have helped to make the Cart page.  |<ul><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/7cd87bd0efdcdc25f1e5ee3d6bf4fc87c7fde1a4">Added HomeController & fixes</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/739978554c55072b88af86e648944ba282779ae0">Updated carrousell & buy item</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/79b436e2f7f4ec62768a5f39df00f453e973d837">Advanced algorithm implemented</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/ae2a7bed7b91422962d1df54edeab5d6830d9198">Final Review(*) & header updated</a></li><li><a href="https://github.com/CodeURJC-DAW-2019-20/MStore/commit/d9d3607a678ab7e345b0820c0d03d1d5321a3cbc">Update README</a></li></ul>|<ul><li>HomeController.java</li><li>index.html</li><li>CartController.java</li><li>ComponentController.java</li><li>shop-single-electronics.html</li></ul>
| Jose Luis Sierra Benito	 | |
| Noelia Martínez Sánchez | Description | <ul><li>item1</li><li>item2</li><li>item3</li><li>item4</li><li>item5</li></ul> | <ul><li>item1</li><li>item2</li><li>item3</li><li>item4</li><li>item5</li></ul>|
| Diego Montoto Ramos | |

---------------------

## Web Application Development Practice 📄

# MSTORE - API REST DOCUMENTATION ⌨️


### About our API 🔍
<p allign="justify">
All you can find in our Rest API is information about users, posts, our brands, your cart, seller ratings, images and other resources. To use our Rest API, follow the rules in this document.
</p>

---------------------

### How to use our API 💡
- [x] Download <a href="https://www.postman.com/">Postman</a>.
- [x] You can send GET,POST,PUT and DELETE request.
---------------------

### API requests 📌📬

#### Resources
<p allign="justify">
The resource API has GET, POST, PUT and DELETE methods. <b>http://localhost:8443</b> followed by the containt request URL.
<b>All API queries have been preceded by /api</b>
</p>

###  1. Authentication
  ###  ___Login___
Alows a user to log in.
- **URL:** http://localhost:8443/api/logIn
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK```

<b>Response:</b>
```json
{
    "id": 1,
    "firstName": "Diego",
    "lastName": "Montoto",
    "email": "dm@gmail.com",
    "phone": "565465456",
    "password": "$2a$10$WZ6RGYyDXm/pq9JLTrkFpuJoYqMzPRVoLxBa8B9UhSC1oE10WixBG",
    "userAddress": null,
    "creditCard": ""
}
```
- ***Error Response ❌:***```401 UNAUTHORIZED```

###  ___Logout___
Alows a user to log out.
- **URL:** http://localhost:8443/api/logOut
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` ```true```
- ***Error Response ❌:***```401 UNAUTHORIZED```
   
   
###  2. Users
  ###  ___Show user___
Show a specific MStore user by id.
- **URL:** http://localhost:8443/api/user/{id}
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>
```json
{
    "id": 1,
    "firstName": "Diego",
    "lastName": "Montoto",
    "email": "dm@gmail.com",
    "phone": "565465456",
    "password": "$2a$10$WZ6RGYyDXm/pq9JLTrkFpuJoYqMzPRVoLxBa8B9UhSC1oE10WixBG",
    "userAddress": null,
    "creditCard": "",
    "tags": [
        "gaming",
        ";overclocked",
        ";overclocked"
    ],
    "roles": [
        "ROLE_USER"
    ],
    "posts": []
}
```
- ***Error Response ❌:*** <br>
```404 NOT FOUND``` <p>If the user ID was not found.</p>

###  ___Modify user profile___
The user can modify their profile.
- **URL:** http://localhost:8443/api/user/{id}
- **Method:** ``` PUT ```
- ***Success Response ✔️:***```200 OK```<br>
<p> <b>Header:</b></p>
  <p>
  - <b>Key:</b> Content-Type <br>
  - <b>Value:</b> application/json
  <p>
<p> <b>Body:</b></p>
  <p>
You need to log in with Basic Auth.
  <p>

```json
{
    "firstName": "Diego",
    "lastName": "Montoto",
    "phone": "68754110",
    "password": "$2a$10$WZ6RGYyDXm/pq9JLTrkFpuJoYqMzPRVoLxBa8B9UhSC1oE10WixBG",
    "userAddress": null,
    "creditCard": ""
}
```
<b>Response:</b>

```json
{
    "id": 1,
    "firstName": "Diego",
    "lastName": "Montoto",
    "email": "dm@gmail.com",
    "phone": "68754110",
    "password": "$2a$10$WaGc/mDDTbSc/aK7NJGWeucJMOKzP98BF0WBHxo638jtnUp6/Uuvy",
    "userAddress": null,
    "creditCard": ""
}
```

- ***Error Response ❌:***<br>
```404 NOT FOUND``` <p>If the user id was not found.</p>
```403 FORBIDDEN``` <p>If the user has not logged in correctly.</p>

###  ___Register an user___
the user can register to MStore.
- **URL:** http://localhost:8443/api/user/
- **Method:** ``` POST ```
- ***Success Response ✔️:***```201 CREATED```<br>
<p> <b>Header:</b></p>
  <p>
  - <b>Key:</b> Content-Type <br>
  - <b>Value:</b> application/json
  <p>
<p> <b>Body:</b></p>

```json
{
    "firstName": "Marcos",
    "lastName": "Ruiz",
    "email": "marcos@gmail.com",
    "phone": "668475454",
    "password": "$2a$10$WaGc/mDDTbSc/aK7NJGWeucJMOKzP98BF0WBHxo638jtnUp6/Uuvy",
    "userAddress": null,
    "creditCard": ""
}
```
<b>Response:</b>

```json
{
    "id": 92,
    "firstName": "Marcos",
    "lastName": "Ruiz",
    "email": "marcos@gmail.com",
    "phone": "668475454",
    "password": "$2a$10$jczB9CNBBlpV.Euq/ovjP.pMsG/84hQSZ36vGJzd5dQOTfcfdkjzG",
    "userAddress": null,
    "creditCard": ""
}
```

- ***Error Response ❌:***<br>
```403 FORBIDDEN``` <p>If the user body request is invalide or there are a user in MStore with the same email.</p>

###  3. Posts

###  4. Brands

 ###  ___Show brands___
Show all MStore brands.
- **URL:** http://localhost:8443/api/brand/
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>
```json
[
    {
        "id": 2,
        "name": "AMD",
        "posts": []
    },
    {
        "id": 28,
        "name": "NVIDIA",
        "posts": []
    },
    {
        "id": 33,
        "name": "HP",
        "posts": [
            {
                "id": 52,
                "nImg": 1,
                "name": "HP laser printer",
                "component": "Laser Printer",
                "price": 130,
                "details": "Not used HP laser printer, comes in the original box",
                "features": "HP laser printer new",
                "postAddress": "Calle del manzano 2",
                "componentTag": 0
            },
            {
                "id": 54,
                "nImg": 1,
                "name": "3D printer golden filament",
                "component": "3D Printer",
                "price": 29,
                "details": "golden filament for any kind and brand of 3d printer",
                "features": "filamnt for 3d printer color: gold",
                "postAddress": "Calle del manzano 2",
                "componentTag": 10
            },
            {
                "id": 67,
                "nImg": 2,
                "name": "HP 27f Ultraslim Full HD",
                "component": "Monitors",
                "price": 180,
                "details": "Built from lightweight, high-strength metal with a matte finish and high-polished resin, this ultra-slim display brings home a modern look and feel without the premium price tag",
                "features": "With its vivid IPS panel, this micro-edge display delivers ultra-wide viewing angles and crisp, clear picture quality; it's an expansive viewing experience, suitable for dual display setups",
                "postAddress": "Limons Street",
                "componentTag": 7
            }
            <.......>
]
```

 ###  ___Show brand___
Show a specific MStore brand by id..
- **URL:** http://localhost:8443/api/brand/{id}
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>
```json
{
    "id": 61,
    "name": "",
    "posts": [
        {
            "id": 65,
            "nImg": 2,
            "name": "Eris E5",
            "component": "",
            "price": 211,
            "details": "Great sounds",
            "features": "70 W\r\n1x 5,25\"",
            "postAddress": "1512 Monroe Avenue Cape Haze, FL 33946",
            "componentTag": 0
        }
    ]
}
```
- ***Error Response ❌:***<br>
```404 NOT_FOUND``` <p>If the brand ID was not found.</p>

###  5. Ratings

 ###  ___Show rating___
Show a specific MStore rating by id.
- **URL:** http://localhost:8443/api/rating/{id}
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>
```json
{
    "id": 61,
    "stars": 3,
    "seller": {
        "id": 47,
        "firstName": "Maria",
        "lastName": "Sanchez",
        "email": "mary@gmail.com",
        "phone": "766578948",
        "password": "$2a$10$vXuN5ZR/Sz7r0zeR0D2ANONrAD68PBH6aMv92UZHpBtqVCsPxgY8S",
        "userAddress": null,
        "creditCard": ""
    },
    "buyer": {
        "id": 42,
        "firstName": "Laura",
        "lastName": "Flores",
        "email": "laurii@gmail.com",
        "phone": "645788342",
        "password": "$2a$10$D6DaCGGzRN9hE7OKZRXNA.3CTH.WHO1VZbiKYrqptCEJnm2dwn.nu",
        "userAddress": null,
        "creditCard": ""
    }
}
```
- ***Error Response ❌:***<br>
```404 NOT_FOUND``` <p>If the rating ID was not found.</p>

###  ___Send a rating___
The user can send a seller rating.
- **URL:** http://localhost:8443/api/rating/
- **Method:** ``` POST ```
- ***Success Response ✔️:***```201 CREATED```<br>
<p> <b>Header:</b></p>
  <p>
  - <b>Key:</b> Content-Type <br>
  - <b>Value:</b> application/json
  </p>
<p> <b>Body:</b></p>

```json
{
    "stars": 3,
    "seller": {
        "id": 47,
        "firstName": "Maria",
        "lastName": "Sanchez",
        "email": "mary@gmail.com"
    },
    "buyer": {
        "id": 42,
        "firstName": "Laura",
        "lastName": "Flores",
        "email": "laurii@gmail.com"
    }
}
```
<b>Response:</b>

```json
{
    "id": 67,
    "stars": 3,
    "seller": {
        "id": 47,
        "firstName": "Maria",
        "lastName": "Sanchez",
        "email": "mary@gmail.com"
    },
    "buyer": {
        "id": 42,
        "firstName": "Laura",
        "lastName": "Flores",
        "email": "laurii@gmail.com"
    }
}
```

- ***Error Response ❌:***<br>
```403 FORBIDDEN``` <p>If the buyer has not logged in or has not purchased the product from the seller</p>



### 6. Images

### 1. USER IMAGES

###  ___Show user image___
A user can see the image of another user.
- **URL:** http://localhost:8443/api/user/{id}/image
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK```<br>

<b>Response:</b>

```json
{
    "headers": {
        "Content-Type": [
            "image/jpeg"
        ]
    },
    "body": {
        "uri": "file:///C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/users/image-1.jpg",
        "url": "file:/C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/users/image-1.jpg",
        "file": "C:\\Users\\Marcos\\Desktop\\URJC\\3\\DAW\\Practica\\MStore\\backend\\images\\users\\image-1.jpg",
        "inputStream": {},
        "description": "URL [file:/C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/users/image-1.jpg]",
        "filename": "image-1.jpg",
        "readable": true,
        "open": false
    },
    "statusCode": "OK",
    "statusCodeValue": 200
}
```

- ***Error Response ❌:***<br>
```404 NOT FOUND``` <p>If the user ID was not found.</p>

###  ___Modify a user image___
The user can modify their user picture.
- **URL:** http://localhost:8443/api/user/{id}/image
- **Method:** ``` PUT ```
- ***Success Response ✔️:***```201 CREATE```<br>

<p> <b>Body:</b></p></p>
  <p>
  - <b>Key:</b> imagenFile(file) <br>
  - <b>Value:</b> file.jpg
  </p>

- ***Error Response ❌:***<br>
```403 FORBIDDEN``` <p>If the user has not logged in correctly.</p>
```404 NOT FOUND``` <p>If the user ID was not found.</p>

###  ___Add a user image___
The user can add a user picture.
- **URL:** http://localhost:8443/api/user/{id}/image
- **Method:** ``` POST ```
- ***Success Response ✔️:***```201 CREATE```<br>

<p> <b>Body:</b></p>
  <p>
  - <b>Key:</b> imagenFile(file) <br>
  - <b>Value:</b> file.jpg
  </p>

- ***Error Response ❌:***<br>
```403 FORBIDDEN``` <p>If the user has not logged in correctly.</p>
```404 NOT FOUND``` <p>If the user ID was not found.</p>
```406 NOT ACCEPTABLE``` <p>If the user already had an image on their profile.</p>

### 2. POST IMAGES

###  ___Show post image___
A user can see the images of a post.
- **URL:** http://localhost:8443/api/post/{id}/image
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK```<br>

<b>Response:</b>
```json
[
    {
        "headers": {
            "Content-Type": [
                "image/jpeg"
            ]
        },
        "body": {
            "uri": "file:///C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/posts/image-44-0.jpg",
            "url": "file:/C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/posts/image-44-0.jpg",
            "file": "C:\\Users\\Marcos\\Desktop\\URJC\\3\\DAW\\Practica\\MStore\\backend\\images\\posts\\image-44-0.jpg",
            "inputStream": {},
            "description": "URL [file:/C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/posts/image-44-0.jpg]",
            "filename": "image-44-0.jpg",
            "readable": true,
            "open": false
        },
        "statusCode": "OK",
        "statusCodeValue": 200
    },
    {
        "headers": {
            "Content-Type": [
                "image/jpeg"
            ]
        },
        "body": {
            "uri": "file:///C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/posts/image-44-1.jpg",
            "url": "file:/C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/posts/image-44-1.jpg",
            "file": "C:\\Users\\Marcos\\Desktop\\URJC\\3\\DAW\\Practica\\MStore\\backend\\images\\posts\\image-44-1.jpg",
            "inputStream": {},
            "description": "URL [file:/C:/Users/Marcos/Desktop/URJC/3/DAW/Practica/MStore/backend/images/posts/image-44-1.jpg]",
            "filename": "image-44-1.jpg",
            "readable": true,
            "open": false
        },
        "statusCode": "OK",
        "statusCodeValue": 200
    }
]
```

- ***Error Response ❌:***<br>
```404 NOT FOUND``` <p>If the user ID post not found or the post do not has images.</p>

###  ___Modify a post image___
The admin can modify a post image.
- **URL:** http://localhost:8443/api/post/{id}-{numimage}/image
- **Method:** ``` PUT ```
- ***Success Response ✔️:***```200 OK```<br>

<p> <b>Body:</b></p>
  <p>
  - <b>Key:</b> imagenFile(file) <br>
  - <b>Value:</b> file.jpg
  </p>

- ***Error Response ❌:***<br>
```403 FORBIDDEN``` <p>Only the admin can update images.</p>
```404 NOT FOUND``` <p>If the post ID or number of image was not found.</p>

###  ___Add a post image___
The user can add a user picture.
- **URL:** http://localhost:8443/api/post/{id}/image
- **Method:** ``` POST ```
- ***Success Response ✔️:***```201 CREATE```<br>

<p> <b>Body:</b></p>
  <p>
  - <b>Key:</b> imagenFile(file) <br>
  - <b>Value:</b> file.jpg
  </p>

- ***Error Response ❌:***<br>
```401 UNAUTHORIZED``` <p>If the user has not logged in correctly.</p>
```403 FORBIDDEN``` <p>If the user has not logged in correctly.</p>
```404 NOT FOUND``` <p>If the post ID was not found.</p>
```406 NOT ACCEPTABLE``` <p>If the user already had an image on their profile.</p>
```507 INSUFFICIENT_STORAGE``` <p>It is not supported to have more than 4 images in a post.</p>

### 7. Cart

 ###  ___Show cart___
Show all cart products brands.
- **URL:** http://localhost:8443/api/cart/
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>
```json
[
    {
        "id": 44,
        "nImg": 3,
        "name": "Blue headphones",
        "component": "Headphones",
        "tags": [
            "sound"
        ],
        "price": 25,
        "details": "Blue logitech headphones with good sound quality, wireless but with cable option.",
        "features": "Blue logitech headphones with good sound quality",
        "postAddress": "Calle de los angeles 7",
        "componentTag": 5,
        "brand": {},
        "user": {}
    },
    {
        "id": 53,
        "nImg": 1,
        "name": "3D printer",
        "component": "3D Printer",
        "tags": [
            "printer"
        ],
        "price": 320,
        "details": "3D printer from brand logitech with blue filament included, drivers not needed",
        "features": "3D logitech branded printer",
        "postAddress": "Calle del manzano 2",
        "componentTag": 10,
        "brand": {},
        "user": {}
    }
]
```


###  ___Update cart___
Visitors can add or remove products from the cart.
- **URL:** http://localhost:8443/api/cart/{id}
- **Method:** ``` POST ```
- ***Success Response ✔️:***```200 OK```<br>

<b>Response:</b>

```json
{
    "id": 44,
    "nImg": 3,
    "name": "Blue headphones",
    "component": "Headphones",
    "tags": [
        "sound"
    ],
    "price": 25,
    "details": "Blue logitech headphones with good sound quality, wireless but with cable option.",
    "features": "Blue logitech headphones with good sound quality",
    "postAddress": "Calle de los angeles 7",
    "componentTag": 5,
    "brand": {},
    "user": {}
}
```

- ***Error Response ❌:***<br>
```404 NOT FOUND``` <p>If the post ID was not found.</p>

###  ___New cart___
New cart is created.
- **URL:** http://localhost:8443/api/cart/
- **Method:** ``` POST ```
- ***Success Response ✔️:***```201 CREATED```<br>

<b>Response:</b>

```json
{ }
```

###  ___Remove all cart products___
The user can remove all cart products.
- **URL:** http://localhost:8443/api/rating/
- **Method:** ``` DELETE ```
- ***Success Response ✔️:***```200 OK```<br>

<b>Response:</b>

```json
{}
```
### 8. Graphics

###  ___Show Graphic___
you can see a seller's rating chart
- **URL:** http://localhost:8443/api/graphic/{id}
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK```<br>

<b>Response:</b>
<p>You need to log in with Basic Auth.</p>


```json
[
    0,
    0,
    0,
    0,
    1,
    0
]
```


- ***Error Response ❌:***<br>
```404 NOT FOUND``` <p>If the user ID was not found.</p>
```401 UNAUTHORIZED```<p>If the user has not logged in correctly.</p>

---------------------

### Instructions for executing the dockerized application 📑

---------------------

### Development Environment 📜

---------------------

### UML Class Diagram 📂📘

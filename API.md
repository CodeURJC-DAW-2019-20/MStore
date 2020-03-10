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
- **URL:** https://localhost:8443/api/logIn
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
- **URL:** https://localhost:8443/api/logOut
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` ```true```
- ***Error Response ❌:***```401 UNAUTHORIZED```
   
   
###  2. Users
  ###  ___Show user___
Show a specific MStore user by id.
- **URL:** https://localhost:8443/api/users/{id}
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
- **URL:** https://localhost:8443/api/users/{id}
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
- **URL:** https://localhost:8443/api/users/
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

 ###  ___Show posts___
Show all MStore posts.
- **URL:** https://localhost:8443/api/posts/
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>
```json
[
    {
        "id": 44,
        "nImg": 3,
        "name": "Blue headphones",
        "component": "Headphones",
        "price": 25,
        "details": "Blue logitech headphones with good sound quality, wireless but with cable option.",
        "features": "Blue logitech headphones with good sound quality",
        "postAddress": "Calle de los angeles 7",
        "componentTag": 5,
        "brand": {
            "id": 43,
            "name": "Logitech"
        }
    },
    {
        "id": 52,
        "nImg": 1,
        "name": "HP laser printer",
        "component": "Laser Printer",
        "price": 130,
        "details": "Not used HP laser printer, comes in the original box",
        "features": "HP laser printer new",
        "postAddress": "Calle del manzano 2",
        "componentTag": 0,
        "brand": {
            "id": 33,
            "name": "HP"
        }
    },
    {
        "id": 53,
        "nImg": 1,
        "name": "3D printer",
        "component": "3D Printer",
        "price": 320,
        "details": "3D printer from brand logitech with blue filament included, drivers not needed",
        "features": "3D logitech branded printer",
        "postAddress": "Calle del manzano 2",
        "componentTag": 10,
        "brand": {
            "id": 43,
            "name": "Logitech"
        }
    }
            <.......>
]
```

 ###  ___Show post___
Show a specific MStore post by name.
- **URL:** https://localhost:8443/api/posts/{id}
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>
```json
{
    "id": 52,
    "nImg": 1,
    "name": "HP laser printer",
    "component": "Laser Printer",
    "tags": [
        "laser",
        "printer",
        "HP"
    ],
    "price": 130,
    "details": "Not used HP laser printer, comes in the original box",
    "features": "HP laser printer new",
    "postAddress": "Calle del manzano 2",
    "componentTag": 0,
    "brand": {
        "id": 33,
        "name": "HP"
    },
    "user": {
        "id": 47,
        "firstName": "Maria",
        "lastName": "Sanchez",
        "email": "mary@gmail.com",
        "phone": "766578948",
        "password": "$2a$10$vXuN5ZR/Sz7r0zeR0D2ANONrAD68PBH6aMv92UZHpBtqVCsPxgY8S",
        "userAddress": null,
        "creditCard": "",
        "tags": [],
        "roles": [
            "ROLE_USER"
        ]
    }
}
```
- ***Error Response ❌:***<br>
```404 NOT_FOUND``` <p>If the post was not found.</p>

###  ___Sell product___
The user can sell a product to MStore.
- **URL:** https://localhost:8443/api/posts/
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
    "name": "HP Monitor",
    "component": "Laser Printer",
    "tags": [
        "monitor","HP"
    ],
    "price": 2500,
    "details": "The best HP monitor",
    "features": "52' full HD",
    "postAddress": "Calle del manzano 22",
    "componentTag": 7,
    "brand": {
        "name": "HP"
    }
}
```
<b>Response:</b>

```json
{
{
    "id": 93,
    "nImg": 0,
    "name": "HP Monitor",
    "component": "Laser Printer",
    "tags": [
        "monitor",
        "HP"
    ],
    "price": 2500,
    "details": "The best HP monitor",
    "features": "52' full HD",
    "postAddress": "Calle del manzano 22",
    "componentTag": 7,
    "brand": {
        "id": 33,
        "name": "HP"
    },
    "user": {
        "id": 58,
        "firstName": "Admin",
        "lastName": "ElAdmin",
        "email": "admin@gmail.com",
        "phone": "67434344",
        "password": "$2a$10$vz56wKtvG9g1bzvpvo42GOjuy.4eLdV5sqaJP6yBui384c0nF1Q6m",
        "userAddress": "Calle del admin 1",
        "creditCard": null,
        "tags": [
            "HP",
            "HP",
            "laser",
            "printer",
            "HP"
        ],
        "roles": [
            "ROLE_USER",
            "ROLE_ADMIN"
        ]
    }
}
}
```

- ***Error Response ❌:***<br>
```401 UNAUTHORIZED``` <p>The user is not logged.</p>

###  ___Modify posts___
The admin can modify posts.
- **URL:** https://localhost:8443/api/posts/{id}
- **Method:** ``` PUT ```
- ***Success Response ✔️:***```200 OK```<br>
<p> <b>Header:</b></p>
  <p>
  - <b>Key:</b> Content-Type <br>
  - <b>Value:</b> application/json
  <p>
<p> <b>Body:</b></p>
  <p>
Admin needs to log in with Basic Auth.
  <p>

```json
{
    "name": "HP Monitor Edit",
    "component": "Monitor",
    "tags": [
        "monitor","HP"
    ],
    "price": 2500,
    "details": "The best HP monitor",
    "features": "52' full HD",
    "postAddress": "Calle del manzano 22",
    "componentTag": 7,
    "brand": {
        "name": "HP"
    }
}
```
<b>Response:</b>

```json
{
    "id": 93,
    "nImg": 0,
    "name": "HP Monitor Edit",
    "component": "Monitor",
    "tags": [
        "monitor",
        "HP"
    ],
    "price": 2500,
    "details": "The best HP monitor",
    "features": "52' full HD",
    "postAddress": "Calle del manzano 22",
    "componentTag": 7,
    "brand": {
        "id": 33,
        "name": "HP"
    },
    "user": {
        "id": 58,
        "firstName": "Admin",
        "lastName": "ElAdmin",
        "email": "admin@gmail.com",
        "phone": "67434344",
        "password": "$2a$10$vz56wKtvG9g1bzvpvo42GOjuy.4eLdV5sqaJP6yBui384c0nF1Q6m",
        "userAddress": "Calle del admin 1",
        "creditCard": null,
        "tags": [
            "HP",
            "HP",
            "laser",
            "printer",
            "HP"
        ],
        "roles": [
            "ROLE_USER",
            "ROLE_ADMIN"
        ]
    }
}
```

- ***Error Response ❌:***<br>
```404 NOT FOUND``` <p>If the post id was not found.</p>
```403 FORBIDDEN``` <p>If the user is not the admin.</p>

###  ___Show recommendations___
Show your recommendations.
- **URL:** https://localhost:8443/api/posts/top_products
- **Method:** ``` GET ```
- ***Success Response ✔️:***```200 OK``` <br>

<b>Response:</b>

```json
[
    {
        "id": 77,
        "nImg": 1,
        "name": "HP Monitor 22er 21,5\"",
        "component": "Monitors",
        "price": 185,
        "details": "Get the crisp image quality you crave thanks to this ultra-thin screen with micro-edges, immersive wide viewing angles and integrated audio. ",
        "features": "",
        "postAddress": "Madrid Street",
        "componentTag": 7,
        "brand": {
            "id": 33,
            "name": "HP"
        }
    },
    {
        "id": 80,
        "nImg": 1,
        "name": "HP X500 Black Wired USB Mouse",
        "component": "Computer Mice",
        "price": 7,
        "details": "Designed with Your Comfort in Mind: The elongated arch and contoured shape provides relaxed control for either right or left-hand users",
        "features": "Inserting the USB cord, you power your mouse and avoid ever replacing batteries\r\nNavigate with the convenient 3 control buttons and central scroll whee",
        "postAddress": "Madrid Street",
        "componentTag": 6,
        "brand": {
            "id": 33,
            "name": "HP"
        }
    },
    {
        "id": 70,
        "nImg": 1,
        "name": "HP Monitor 27m 68,58 cm (27\" ), IPS, Full HD",
        "component": "Monitors",
        "price": 270,
        "details": "Enjoy a great screen experience with this elegant HP monitor. Advanced IPS technology provides very wide viewing angles of up to 178 ° with consistent details and vibrant colors.",
        "features": "IPS display with 68.58 cm (27 \") LED backlight\r\nMicro-edge display, Ultrathin, Very wide viewing angles up to 178 °",
        "postAddress": "Madrid Street",
        "componentTag": 7,
        "brand": {
            "id": 33,
            "name": "HP"
        }
    }
]
```

###  4. Brands

 ###  ___Show brands___
Show all MStore brands.
- **URL:** https://localhost:8443/api/brands/
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
- **URL:** https://localhost:8443/api/brands/{id}
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
- **URL:** https://localhost:8443/api/ratings/{id}
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
- **URL:** https://localhost:8443/api/ratings/
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
- **URL:** https://localhost:8443/api/users/{id}/images
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
- **URL:** https://localhost:8443/api/users/{id}/images
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
- **URL:** https://localhost:8443/api/users/{id}/images
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
- **URL:** https://localhost:8443/api/posts/{id}/images
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
- **URL:** https://localhost:8443/api/posts/{id}-{numimage}/images
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
- **URL:** https://localhost:8443/api/posts/{id}/images
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
- **URL:** https://localhost:8443/api/carts/
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
- **URL:** https://localhost:8443/api/carts/{id}
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
- **URL:** https://localhost:8443/api/carts/
- **Method:** ``` POST ```
- ***Success Response ✔️:***```201 CREATED```<br>

<b>Response:</b>

```json
{ }
```

###  ___Remove all cart products___
The user can remove all cart products.
- **URL:** https://localhost:8443/api/carts/
- **Method:** ``` DELETE ```
- ***Success Response ✔️:***```200 OK```<br>

<b>Response:</b>

```json
{}
```
### 8. Graphics

###  ___Show Graphic___
you can see a seller's rating chart
- **URL:** https://localhost:8443/api/graphics/{id}
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


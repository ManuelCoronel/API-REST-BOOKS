# API-REST-BOOKS

## DEMO 

[manuel.westus3.cloudapp.azure.com/api/](manuel.westus3.cloudapp.azure.com/api/)

## HOW TO USE 

### create a category - POST

  `manuel.westus3.cloudapp.azure.com/api/categorias`

### Body
```
 {
  "nombre":"Magia"
 } 
```
### Response
```
{
    "id": 2,
    "nombre": "Magia"
} 
```

### List all categories - GET

  `manuel.westus3.cloudapp.azure.com/api/categorias`

### Response
```
[
    {
        "id": 1,
        "nombre": "Magia"
    }
]
```



### UPLOAD IMAGE BOOK - POST

  `manuel.westus3.cloudapp.azure.com/api/assets/upload`

### Body
```
key:file
value : (the file)
```
### Response
```
{
    "key": "a5494699-349a-4049-8905-de645fc6c820.jpg",
    "url": "https://springbooks.s3.amazonaws.com/a5494699-349a-4049-8905-de645fc6c820.jpg"
}
```
### DELETE IMAGE BOOK - DELETE

  `localhost:8080/api/assets/delete-object?key={KEY}`





### CREATE BOOK - POST

  `http://manuel.westus3.cloudapp.azure.com/api/libros/`

### Body
```
{
        "titulo":"La piedra Filosofal",
        "imagenPath":"a5494699-349a-4049-8905-de645fc6c820.jpg",
         "categoria":{
        "id" : 1
        }
    }

```
### Response
```
{
    "id": 2,
    "titulo": "La piedra Filosofal",
    "imagenPath": "a5494699-349a-4049-8905-de645fc6c820.jpg",
    "imagenUrl": "https://springbooks.s3.amazonaws.com/a5494699-349a-4049-8905-de645fc6c820.jpg",
    "categoria": {
        "id": 1,
        "nombre": null
    }
}
```

### LIST ALL BOOKS - GET

  `http://manuel.westus3.cloudapp.azure.com/api/libros/`


### Response
```
[
    {
        "id": 2,
        "titulo": "La piedra Filosofal",
        "imagenPath": "a5494699-349a-4049-8905-de645fc6c820.jpg",
        "imagenUrl": "https://springbooks.s3.amazonaws.com/a5494699-349a-4049-8905-de645fc6c820.jpg",
        "categoria": {
            "id": 1,
            "nombre": "Magia"
        }
    }
]
```

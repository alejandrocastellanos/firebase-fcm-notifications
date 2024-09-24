# Proyecto de Notificaciones Push con Firebase Cloud Messaging (FCM)

Este proyecto es una aplicación de ejemplo en Java utilizando Spring Boot para enviar notificaciones push a dispositivos móviles mediante Firebase Cloud Messaging (FCM).

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior
- [Firebase Project](https://firebase.google.com/)
- [Firebase Admin SDK](https://firebase.google.com/docs/admin/setup)


# How to Use

- ./mvnw clean package
- docker compose up --build

## Endpoints

### - SINGLE NOTIFICATION

#### POST: `/single-push-notification`

Este endpoint se utiliza para enviar una notificación push a un dispositivo específico.

#### Requiere

- **URL**: `http://localhost:8082/single-push-notification`
- **Método**: `POST`
- **Headers**:
    - `Content-Type: application/json`

#### Datos de entrada

El cuerpo de la solicitud debe ser un objeto JSON que contenga los siguientes campos:

```
{
    "token": "FCM_TOKEN",
    "title": "TITULO DE LA NOTIFICACION",
    "body": "CUERPO DEL MENSAJE"
}
```

### - BATCH NOTIFICATION

#### POST: `/batch-push-notifications`

Este endpoint se utiliza para enviar una notificación push a un dispositivo específico.

#### Requiere

- **URL**: `http://localhost:8082/batch-push-notifications`
- **Método**: `POST`
- **Headers**:
    - `Content-Type: application/json`

#### Datos de entrada

El cuerpo de la solicitud debe ser un objeto JSON que contenga los siguientes campos:

```
{
    "tokens": ["FCM_TOKEN", "FCM_TOKEN", "FCM_TOKEN", "FCM_TOKEN"],
    "title": "TITULO DE LA NOTIFICACION",
    "body": "CUERPO DEL MENSAJE"
}
```
# Entrevista Intermedia

## Requisitos

- Java JDK 17
- Maven
- PostgreSQL
- Docker

## Clonando el Proyecto

Para clonar este proyecto, sigue estos pasos:

1. Asegúrate de tener [Git](https://git-scm.com/downloads) instalado en tu máquina.
2. Abre una terminal o línea de comandos.
3. Navega al directorio donde deseas clonar el proyecto.
4. Ejecuta el siguiente comando:

   ```bash
   git clone https://github.com/DanCmoo/EntrevistaIntermedia.git
   git checkout develop
5. Ejecuta el proyecto

   ```bash
   mvn spring-boot:run

# Endpoints de la API de Asamblea

La colección de peticiones de Postman está en el directorio docs/

## Listar Asambleas
- **GET** `/api/asamblea/listar`
  - **Descripción**: Obtiene una lista de todas las asambleas.

## Buscar Asamblea por ID
- **GET** `/api/asamblea/{id}`
  - **Descripción**: Busca una asamblea por su ID.
  - **Parámetros**:
    - `id`: UUID de la asamblea.

## Crear Asamblea
- **POST** `/api/asamblea/crear`
  - **Descripción**: Crea una nueva asamblea.
  - **Cuerpo de la Solicitud**: `AsambleaDTO` (definido en el modelo).

## Eliminar Asamblea
- **DELETE** `/api/asamblea/eliminar/{id}`
  - **Descripción**: Elimina una asamblea por su ID.
  - **Parámetros**:
    - `id`: UUID de la asamblea.

## Actualizar Estado de Asamblea
- **PUT** `/api/asamblea/estado/{id}`
  - **Descripción**: Actualiza el estado de una asamblea por su ID.
  - **Parámetros**:
    - `id`: UUID de la asamblea.
  - **Cuerpo de la Solicitud**: `AsambleaDTO` (contiene el nuevo estado).

## Crear Participante en Asamblea
- **POST** `/api/asamblea/crearParticipante/{id}`
  - **Descripción**: Crea un nuevo participante y lo asigna a una asamblea por su ID.
  - **Parámetros**:
    - `id`: UUID de la asamblea.
  - **Cuerpo de la Solicitud**: `ParticipanteDTO` (definido en el modelo).

## Crear Participante
- **POST** `/api/asamblea/crearParticipante`
  - **Descripción**: Crea un nuevo participante.
  - **Cuerpo de la Solicitud**: `ParticipanteDTO` (definido en el modelo).

## Listar Participantes
- **GET** `/api/asamblea/participante/listar`
  - **Descripción**: Obtiene una lista de todos los participantes.

## Eliminar Participante
- **DELETE** `/api/asamblea/participante/{id}`
  - **Descripción**: Elimina un participante por su ID.
  - **Parámetros**:
    - `id`: UUID del participante.

## Asignar Participante a Asamblea
- **PUT** `/api/asamblea/asignarParticipante`
  - **Descripción**: Asigna un participante existente a una asamblea.
  - **Cuerpo de la Solicitud**: `ParticipanteDTO` (contiene la información del participante y la asamblea).

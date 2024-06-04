# Audio & Video Streaming Engine in Java Spring Boot 
### (Still in development in progress)

### Audio & Video Streaming project structure looks like this:

### Components:

##  Media Ingestion Service (Spring Boot):

Accepts uploaded video and audio files from users.
Validates file format and size.
Transforms media files (optional):
Convert to compatible streaming formats (e.g., HLS for video, MP3 for audio).
Generate thumbnails or previews.
Publishes metadata (file name, size, description) and file chunks to separate Kafka topics.
Media Storage Service:

### Consumes file chunks from the Kafka topic.
    1. Stores the chunks in a scalable storage solution like Amazon S3 or Google Cloud Storage.
    2. Stores metadata in MongoDB for easy retrieval.
    3. Media Streaming Service (Spring Boot):

### Consumes metadata from the Kafka topic.
Retrieves file chunks from the storage solution based on user requests.
Serves the media content progressively using a streaming server like Nginx-RTMP.
User Management Service (Spring Boot):

### Handles user registration, login, and authentication.
Stores user information and preferences in MongoDB.
API Gateway:

### Single entry point for user interactions.
Routes requests to the appropriate service (upload, playback, user management).
Handles security (authentication, authorization).
Apache Kafka:

## Acts as a distributed streaming platform:
### Topics:
    1. "media-uploads": For metadata and file chunks from the ingestion service.
    2. "media-metadata": For storing media metadata in MongoDB (optional).
    3.  Enables decoupling of services and fault tolerance.


### MongoDB:
Stores metadata about uploaded media files (title, description, etc.).
Can be used for storing user information (optional, depending on user management needs).

### Workflow:
User uploads a video or audio file through the API.
Media Ingestion Service validates and prepares the file.
Service publishes metadata to the "media-metadata" topic (optional) and file chunks to the "media-uploads" topic.
Media Storage Service consumes chunks and stores them in cloud storage.
User requests playback through the API.
Media Streaming Service retrieves metadata and file chunk locations from MongoDB.
Streaming server retrieves chunks from cloud storage and delivers them progressively to the user.

### Benefits:
Scalability: Kafka and cloud storage enable handling large volumes of media files and concurrent users.
Fault Tolerance: Kafka ensures data delivery even if some components fail.
Decoupling: Services are independent and can be scaled independently.
Flexibility: Supports various media formats and streaming protocols.
Additional Considerations:

Security: Implement authentication and authorization mechanisms for user access and media management.
Monitoring and logging: Monitor system health, track upload/playback activity, and troubleshoot issues.
Content Delivery Network (CDN): Consider using a CDN for geographically distributed content delivery and reduced latency.
User Interface: Develop a user-friendly interface for media upload, playback, and user management.


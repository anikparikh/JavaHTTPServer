# Java HTTP Server

A simple multi-threaded HTTP server written in Java using low-level `ServerSocket` and `Socket` APIs. This project demonstrates how to manually handle HTTP requests and responses, implement basic routing, and serve multiple clients concurrently using threads.

---

## 🚀 Features

- Handles multiple simultaneous connections using Java threads
- Manually parses HTTP GET requests and returns custom responses
- Sends valid HTTP headers and supports HTML content
- Includes a simple routing mechanism
- Load tested with [ApacheBench (ab)](https://httpd.apache.org/docs/2.4/programs/ab.html)
- Achieved **>500 requests per second**

---

## 🛠 Technologies Used

- Java (8+)
- `ServerSocket`, `Socket`
- Multithreading (`Runnable`, `Thread`)
- ApacheBench (for performance testing)

---

## 📁 File Structure

JavaHTTPServer/
├── SimpleHTTPServer.java # Basic single-threaded version
├── MultiThreadedHTTPServer.java # Multi-threaded implementation
├── README.md
└── .gitignore

---

## 🧪 Running the Server

### Compile

```bash
javac MultiThreadedHTTPServer.java
java MultiThreadedHTTPServer
The server listens on http://localhost:8080

💻 Example Response
When accessed in the browser, it returns:

html
Copy
Edit
<html>
  <body>
    <h1>Hello from Multi-threaded Java Server!</h1>
    <p>Sat May 31 16:06:23 EDT 2025</p>
  </body>
</html>
Tested with ApacheBench:

bash
Copy
Edit
ab -n 1000 -c 50 http://localhost:8080/
Achieved >500 RPS on a local machine.

🧠 Lessons Learned
Gained hands-on experience with Java's networking and multithreading APIs

Learned how HTTP works at the protocol level (headers, status codes, etc.)

Implemented core web server functionality from scratch without using frameworks


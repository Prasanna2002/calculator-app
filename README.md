## This Repo Contains source code of my mini project scientific -Calculator as part of my Mtech Curriculum (CS 816- Software Production Engineering).
This project demonstrates an automated Devops workflow for a Java-based Scientific Calculator application. The lifecycle includes building the project with Maven, then automating the build process and making it executable using Jenkins, later on containerization with Docker,converting the executable .JAR file into Docker Image and storing it in Docker Hub, and Automated deployment using Ansible (pulling the image from Docker Hub and running it inside a newly created container).
Upon Successfull Completion of the Pipeline stages the email notification will be sent to given email address by jenkins regarding the Build Status. 

## Tools & Technology
    • Version Control : Git & Github
    • Build Tool : Apache Maven 
    • Continuous Integration : Jenkins 
    • Containerization : Docker
    • Registry: DockerHub
    • Configuration Management : Ansible

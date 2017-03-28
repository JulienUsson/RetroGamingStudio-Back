# Subject :

Link : `https://github.com/bkuchcik/cours-jee-isima/blob/master/sujets/Sujet%20TP%20final.pdf`

# API :

## Game :

Read All : GET `http://localhost:8080/games`

Read One : GET `http://localhost:8080/games/2`

Write One : POST `http://localhost:8080/games`

    {
        "name":"Mario Bros",
        "playability":5,
        "graphics":1,
        "interest":9
    }

Delete One : `DELETE http://localhost:8080/games/2`

## Console :

Read All : GET `http://localhost:8080/consoles`

Read One : GET `http://localhost:8080/consoles/2`

Write : POST `http://localhost:8080/consoles`

    {
        "name":"ps3"
    }

Delete One : `DELETE http://localhost:8080/consoles/2`

# Application

Build the app :

  - directly with IntelliJ
  - with maven `mvn clean package`

Run the app :

  - copy the .war in `/var/lib/tomcat8/webapps`, then restart tomcat server
  - directly run `mvn spring-boot:run` (don't forget to stop **tomcat** before)

Access to the app :

  - with tomcat server and deployed war : http://localhost:8080/{app-name}/
  - with the "mvn solution" : http://localhost:8080/


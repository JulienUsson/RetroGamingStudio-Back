#Subject :

    https://github.com/bkuchcik/cours-jee-isima/blob/master/sujets/Sujet%20TP%20final.pdf

Build the app :

  - directly with IntelliJ
  - with maven `mvn clean package`

Run the app :

  - copy the .war in `/var/lib/tomcat8/webapps`, then restart tomcat server
  - directly run `mvn spring-boot:run` (don't forget to stop **tomcat** before)

Access to the app :

  - with tomcat server and deployed war : http://localhost:8080/{app-name}/
  - with the "mvn solution" : http://localhost:8080/

#API :

##Game :

Read : GET `http://localhost:8080/games`
Write : POST `http://localhost:8080/games`

    {
        name:"Mario Bros",
        playability:5,
        graphics:1,
        interest:9
    }

##Console :

Read : GET `http://localhost:8080/consoles`
Write : POST `http://localhost:8080/consoles`

    {
        "name":"ps3"
    }


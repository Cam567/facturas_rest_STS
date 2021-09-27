pipeline {

    agent any
    stages {

        stage("Descargar código de la aplicación"){
            steps{
                git "https://github.com/jesuscle/NOMBRE_REPOSITORIO"
            } 
        } 

        stage("Compilar y empaquetar el proyecto") {
            steps {
                script {
                    if(isUnix()){
                        sh "mvn clean package"
                    }else{
                        bat "mvn clean package"
                    }
                }
            }
        }        

        stage("Creación de imagen"){
            steps{
                script {
                    if(isUnix()){
                        sh "docker build -t jsalinas/app-java ."
                    }else{
                        bat "docker build -t jsalinas/app-java ."
                    }
                }
                
            } 
        }

        stage("Creación y ejecución de contenedor"){
           steps {
               script {
                    if(isUnix()){
                        sh "docker run -d --name app-java -p 18080:8080 jsalinas/app-java"
                    }else{
                        bat "docker run -d --name app-java -p 18080:8080 jsalinas/app-java"
                    }
               }
           }
        }

        stage("Test del servicio"){
            steps {
                echo "Probando el servicio ..."
            }
        }

        stage("Cerrar recursos"){
           steps {
               script{
                    if(isUnix()){
                        sh "docker stop app-java"
                        sh "docker container rm app-java" 
                        sh "docker image rm jsalinas/app-java" 
                    }else{
                        bat "docker stop app-java"
                        bat "docker container rm app-java" 
                        bat "docker image rm jsalinas/app-java" 
                    }
               }
            }            
        }
    }
}